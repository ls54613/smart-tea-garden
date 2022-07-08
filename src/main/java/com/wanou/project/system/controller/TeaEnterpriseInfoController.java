package com.wanou.project.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wanou.framework.aspectj.lang.annotation.Log;
import com.wanou.framework.aspectj.lang.enums.BusinessType;
import com.wanou.project.system.domain.TeaEnterpriseInfo;
import com.wanou.project.system.service.ITeaEnterpriseInfoService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶企基本信息Controller
 *
 * @author MrYao
 * @date 2022-03-01
 */
@RestController
@CrossOrigin
@RequestMapping("/system/teaEnterpriseInfo")
public class TeaEnterpriseInfoController extends BaseController
{
    @Autowired
    private ITeaEnterpriseInfoService teaEnterpriseInfoService;

    /**
     * 查询茶企基本信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TeaEnterpriseInfo teaEnterpriseInfo)
    {
        startPage();
        List<TeaEnterpriseInfo> list = teaEnterpriseInfoService.selectTeaEnterpriseInfoList(teaEnterpriseInfo);
        return getDataTable(list);
    }


    @GetMapping("/findAll")
    public AjaxResult listAll(TeaEnterpriseInfo teaEnterpriseInfo){
        List<TeaEnterpriseInfo> teaEnterpriseInfos = teaEnterpriseInfoService.selectTeaEnterpriseInfoList(teaEnterpriseInfo);
        return AjaxResult.success(teaEnterpriseInfos);
    }

    /**
     * 导出茶企基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseInfo:export')")
    @Log(title = "茶企基本信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaEnterpriseInfo teaEnterpriseInfo)
    {
        List<TeaEnterpriseInfo> list = teaEnterpriseInfoService.selectTeaEnterpriseInfoList(teaEnterpriseInfo);
        ExcelUtil<TeaEnterpriseInfo> util = new ExcelUtil<TeaEnterpriseInfo>(TeaEnterpriseInfo.class);
        return util.exportExcel(list, "茶企基本信息数据");
    }

    /**
     * 获取茶企基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaEnterpriseInfoService.selectTeaEnterpriseInfoById(id));
    }

    /**
     * 新增茶企基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseInfo:add')")
    @Log(title = "茶企基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaEnterpriseInfo teaEnterpriseInfo)
    {
        return toAjax(teaEnterpriseInfoService.insertTeaEnterpriseInfo(teaEnterpriseInfo));
    }

    /**
     * 修改茶企基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseInfo:edit')")
    @Log(title = "茶企基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaEnterpriseInfo teaEnterpriseInfo)
    {
        return toAjax(teaEnterpriseInfoService.updateTeaEnterpriseInfo(teaEnterpriseInfo));
    }

    /**
     * 删除茶企基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseInfo:remove')")
    @Log(title = "茶企基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaEnterpriseInfoService.deleteTeaEnterpriseInfoByIds(ids));
    }
}
