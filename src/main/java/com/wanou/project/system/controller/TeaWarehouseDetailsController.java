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
import com.wanou.project.system.domain.TeaWarehouseDetails;
import com.wanou.project.system.service.ITeaWarehouseDetailsService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶仓详情Controller
 *
 * @author ruoyi
 * @date 2022-03-07
 */
@RestController
@RequestMapping("/system/teaWarehouseDetails")
public class TeaWarehouseDetailsController extends BaseController
{
    @Autowired
    private ITeaWarehouseDetailsService teaWarehouseDetailsService;

    /**
     * 查询茶仓详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:details:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaWarehouseDetails teaWarehouseDetails)
    {
        startPage();
        List<TeaWarehouseDetails> list = teaWarehouseDetailsService.selectTeaWarehouseDetailsList(teaWarehouseDetails);
        return getDataTable(list);
    }

    /**
     * 导出茶仓详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:details:export')")
    @Log(title = "茶仓详情", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaWarehouseDetails teaWarehouseDetails)
    {
        List<TeaWarehouseDetails> list = teaWarehouseDetailsService.selectTeaWarehouseDetailsList(teaWarehouseDetails);
        ExcelUtil<TeaWarehouseDetails> util = new ExcelUtil<TeaWarehouseDetails>(TeaWarehouseDetails.class);
        return util.exportExcel(list, "茶仓详情数据");
    }

    /**
     * 获取茶仓详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:details:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaWarehouseDetailsService.selectTeaWarehouseDetailsById(id));
    }

    /**
     * 新增茶仓详情
     */
    @PreAuthorize("@ss.hasPermi('system:details:add')")
    @Log(title = "茶仓详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaWarehouseDetails teaWarehouseDetails)
    {
        return toAjax(teaWarehouseDetailsService.insertTeaWarehouseDetails(teaWarehouseDetails));
    }

    /**
     * 修改茶仓详情
     */
    @PreAuthorize("@ss.hasPermi('system:details:edit')")
    @Log(title = "茶仓详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaWarehouseDetails teaWarehouseDetails)
    {
        return toAjax(teaWarehouseDetailsService.updateTeaWarehouseDetails(teaWarehouseDetails));
    }

    /**
     * 删除茶仓详情
     */
    @PreAuthorize("@ss.hasPermi('system:details:remove')")
    @Log(title = "茶仓详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaWarehouseDetailsService.deleteTeaWarehouseDetailsByIds(ids));
    }
}
