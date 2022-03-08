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
import com.wanou.project.system.domain.TeaEnterpriseProcurement;
import com.wanou.project.system.service.ITeaEnterpriseProcurementService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 近半年采购情况Controller
 *
 * @author MrYao
 * @date 2022-03-03
 */
@RestController
@RequestMapping("/system/teaEnterpriseProcurement")
public class TeaEnterpriseProcurementController extends BaseController
{
    @Autowired
    private ITeaEnterpriseProcurementService teaEnterpriseProcurementService;

    /**
     * 查询近半年采购情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseProcurement:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaEnterpriseProcurement teaEnterpriseProcurement)
    {
        startPage();
        List<TeaEnterpriseProcurement> list = teaEnterpriseProcurementService.selectTeaEnterpriseProcurementList(teaEnterpriseProcurement);
        return getDataTable(list);
    }

    /**
     * 导出近半年采购情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseProcurement:export')")
    @Log(title = "近半年采购情况", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaEnterpriseProcurement teaEnterpriseProcurement)
    {
        List<TeaEnterpriseProcurement> list = teaEnterpriseProcurementService.selectTeaEnterpriseProcurementList(teaEnterpriseProcurement);
        ExcelUtil<TeaEnterpriseProcurement> util = new ExcelUtil<TeaEnterpriseProcurement>(TeaEnterpriseProcurement.class);
        return util.exportExcel(list, "近半年采购情况数据");
    }

    /**
     * 获取近半年采购情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseProcurement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaEnterpriseProcurementService.selectTeaEnterpriseProcurementById(id));
    }

    /**
     * 新增近半年采购情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseProcurement:add')")
    @Log(title = "近半年采购情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaEnterpriseProcurement teaEnterpriseProcurement)
    {
        return toAjax(teaEnterpriseProcurementService.insertTeaEnterpriseProcurement(teaEnterpriseProcurement));
    }

    /**
     * 修改近半年采购情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseProcurement:edit')")
    @Log(title = "近半年采购情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaEnterpriseProcurement teaEnterpriseProcurement)
    {
        return toAjax(teaEnterpriseProcurementService.updateTeaEnterpriseProcurement(teaEnterpriseProcurement));
    }

    /**
     * 删除近半年采购情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseProcurement:remove')")
    @Log(title = "近半年采购情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaEnterpriseProcurementService.deleteTeaEnterpriseProcurementByIds(ids));
    }
}
