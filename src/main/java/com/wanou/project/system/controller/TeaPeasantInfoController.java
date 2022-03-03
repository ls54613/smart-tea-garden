package com.wanou.project.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wanou.framework.aspectj.lang.annotation.Log;
import com.wanou.framework.aspectj.lang.enums.BusinessType;
import com.wanou.project.system.domain.TeaPeasantInfo;
import com.wanou.project.system.service.ITeaPeasantInfoService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶农基本信息Controller
 *
 * @author ruoyi
 * @date 2022-03-02
 */
@RestController
@RequestMapping("/system/teaPeasantInfo")
public class TeaPeasantInfoController extends BaseController
{
    @Autowired
    private ITeaPeasantInfoService teaPeasantInfoService;

    /**
     * 查询茶农基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaPeasantInfo teaPeasantInfo)
    {
        startPage();
        List<TeaPeasantInfo> list = teaPeasantInfoService.selectTeaPeasantInfoList(teaPeasantInfo);
        return getDataTable(list);
    }

    /**
     * 导出茶农基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantInfo:export')")
    @Log(title = "茶农基本信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaPeasantInfo teaPeasantInfo)
    {
        List<TeaPeasantInfo> list = teaPeasantInfoService.selectTeaPeasantInfoList(teaPeasantInfo);
        ExcelUtil<TeaPeasantInfo> util = new ExcelUtil<TeaPeasantInfo>(TeaPeasantInfo.class);
        return util.exportExcel(list, "茶农基本信息数据");
    }

    /**
     * 获取茶农基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaPeasantInfoService.selectTeaPeasantInfoById(id));
    }

    /**
     * 新增茶农基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantInfo:add')")
    @Log(title = "茶农基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaPeasantInfo teaPeasantInfo)
    {
        return toAjax(teaPeasantInfoService.insertTeaPeasantInfo(teaPeasantInfo));
    }

    /**
     * 修改茶农基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantInfo:edit')")
    @Log(title = "茶农基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaPeasantInfo teaPeasantInfo)
    {
        return toAjax(teaPeasantInfoService.updateTeaPeasantInfo(teaPeasantInfo));
    }

    /**
     * 删除茶农基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantInfo:remove')")
    @Log(title = "茶农基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaPeasantInfoService.deleteTeaPeasantInfoByIds(ids));
    }
}
