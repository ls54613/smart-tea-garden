package com.wanou.project.system.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.poi.excel.ExcelReader;
import com.aliyun.oss.model.SimplifiedObjectMeta;
import com.wanou.common.component.OSS.OSSComponent;
import com.wanou.common.utils.ServletUtils;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.aspectj.lang.annotation.Log;
import com.wanou.framework.aspectj.lang.enums.BusinessType;
import com.wanou.framework.security.LoginUser;
import com.wanou.framework.security.service.TokenService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.framework.web.page.TableDataInfo;
import com.wanou.project.system.domain.SysUser;
import com.wanou.project.system.domain.TxPerson;
import com.wanou.project.system.domain.TxPersonExcel;
import com.wanou.project.system.service.ITxPersonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 员工管理Controller
 *
 * @author wanou
 * @date 2021-08-11
 */
@RestController
@RequestMapping("/system/person")
public class TxPersonController extends BaseController
{
    @Autowired
    private ITxPersonService txPersonService;

    @Autowired
    private TokenService tokenService;

    @Value("${unzipPath}")
    private File unzipPath;

    @Value("${zipSavePath}")
    private File zipSavePath;

    @Autowired
    private OSSComponent ossComponent;

    /**
     * 查询员工管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:person:list')")
    @GetMapping("/list")
    public TableDataInfo list(TxPerson txPerson)
    {
        startPage();
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        List<TxPerson> list = txPersonService.selectTxPersonList(txPerson);
        return getDataTable(list);
    }

    /**
     * 导出员工管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:person:export')")
    @Log(title = "员工管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TxPerson txPerson)
    {
        List<TxPerson> list = txPersonService.selectTxPersonList(txPerson);
        ExcelUtil<TxPerson> util = new ExcelUtil<TxPerson>(TxPerson.class);
        return util.exportExcel(list, "员工管理数据");
    }

    /**
     * 获取员工管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:person:query')")
    @GetMapping(value = "/{staffid}")
    public AjaxResult getInfo(@PathVariable("staffid") Long staffid)
    {
        return AjaxResult.success(txPersonService.selectTxPersonByStaffid(staffid));
    }

    /**
     * 新增员工管理
     */
    @PreAuthorize("@ss.hasPermi('system:person:add')")
    @Log(title = "员工管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TxPerson txPerson)
    {
        return toAjax(txPersonService.insertTxPerson(txPerson));
    }

    /**
     * 修改员工管理
     */
    @PreAuthorize("@ss.hasPermi('system:person:edit')")
    @Log(title = "员工管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TxPerson txPerson)
    {
        return toAjax(txPersonService.updateTxPerson(txPerson));
    }

    /**
     * 删除员工管理
     */
    @PreAuthorize("@ss.hasPermi('system:person:remove')")
    @Log(title = "员工管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{staffids}")
    public AjaxResult remove(@PathVariable Long[] staffids)
    {
        return toAjax(txPersonService.deleteTxPersonByStaffids(staffids));
    }

    @Log(title = "员工管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:person:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport, String zipPath) throws Exception
    {
        long start = System.currentTimeMillis();
        if(StringUtils.isBlank(zipPath)){
            return AjaxResult.error("zip未上传");
        }

        //判断本地zip是否存在
        File currentZip = new File(zipSavePath.getPath() + zipPath.substring(zipPath.lastIndexOf("/")));
        if(!currentZip.exists()){
            //不存在 下载
            //下载zip解压
            byte[] bytes = ossComponent.downFile4Stream(zipPath);
            FileUtil.writeBytes(bytes, currentZip);
        }

        File unzip = ZipUtil.unzip(currentZip,unzipPath);
        List<File> files = FileUtil.loopFiles(unzip);

        ExcelReader reader = cn.hutool.poi.excel.ExcelUtil.getReader(file.getInputStream());
        List<List<Object>> read = reader.read();
        read.remove(0);
        List<TxPerson> userList = new ArrayList<>();
        for (List<Object> objects : read) {
            TxPerson txPerson = new TxPerson();
            txPerson.setIdcardNum(objects.get(0).toString());
            txPerson.setMobile(objects.get(1).toString());
            txPerson.setName(objects.get(2).toString());
            txPerson.setDepartmentId(Long.valueOf(objects.get(3).toString()));
            txPerson.setDomainId(objects.get(4).toString());
            txPerson.setSex(Integer.valueOf(objects.get(5).toString()));
            txPerson.setAddress(objects.get(6).toString());
            userList.add(txPerson);
        }
        /*ExcelUtil<TxPerson> util = new ExcelUtil<TxPerson>(TxPerson.class);
        List<TxPerson> userList = util.importExcel(file.getInputStream());*/
        for (TxPerson txPerson : userList) {
            for (File imgFile : files) {
                if(imgFile.getName().contains(txPerson.getIdcardNum())){
                    //上传
                    //判断是否已存在相同文件
                    String md5 = SecureUtil.md5(imgFile);
                    String faceImageObjectName = "face_image/" + txPerson.getIdcardNum() + ".jpg";
                    SimplifiedObjectMeta faceImageMeta = ossComponent.getObjectMetaSimplified(faceImageObjectName);
                    if(faceImageMeta == null || !faceImageMeta.getETag().equalsIgnoreCase(md5)){
                        ossComponent.uploadByte(faceImageObjectName,FileUtil.readBytes(imgFile));
                    }

                    String licenseImageObjectName = "license_image/" + txPerson.getIdcardNum() + ".jpg";
                    SimplifiedObjectMeta licenseImageMeta = ossComponent.getObjectMetaSimplified(licenseImageObjectName);
                    if(licenseImageMeta == null || !licenseImageMeta.getETag().equalsIgnoreCase(md5)){
                        ossComponent.uploadByte(licenseImageObjectName,FileUtil.readBytes(imgFile));
                    }
                    txPerson.setImgBase64(faceImageObjectName);
                    txPerson.setLicenseImage(licenseImageObjectName);
                    break;
                }
            }
            if(StringUtils.isBlank(txPerson.getImgBase64())){
                return AjaxResult.error("员工没有对应图片,请检查图片压缩包与录入信息是否一致");
            }
        }
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = txPersonService.importTxPerson(userList, updateSupport, operName);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        return AjaxResult.success(message);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<TxPersonExcel> util = new ExcelUtil<TxPersonExcel>(TxPersonExcel.class);
        return util.importTemplateExcel("员工数据");
    }

    /**
     * 生成人员与小程序用户绑定的二维码
     * @return
     */
    @GetMapping("/generatePersonBindQrCode/{personId}")
    public AjaxResult generatePersonBindCode(@PathVariable("personId") Long personId){
        String base64 = txPersonService.generatePersonBindQrCode(personId);
        return AjaxResult.success("成功",base64);
    }
}
