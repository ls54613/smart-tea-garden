package com.wanou.project.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wanou.framework.aspectj.lang.annotation.Log;
import com.wanou.framework.aspectj.lang.enums.BusinessType;
import com.wanou.project.system.domain.TeaEnterpriseYieldSales;
import com.wanou.project.system.service.ITeaEnterpriseYieldSalesService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 企业历年产量及销售情况Controller
 *
 * @author ruoyi
 * @date 2022-03-07
 */
@RestController
@CrossOrigin
@RequestMapping("/system/teaEnterpriseYieldSales")
public class TeaEnterpriseYieldSalesController extends BaseController
{
    @Autowired
    private ITeaEnterpriseYieldSalesService teaEnterpriseYieldSalesService;

    /**
     * 查询企业历年产量及销售情况列表
     */

    @GetMapping("/list")
    public TableDataInfo list(TeaEnterpriseYieldSales teaEnterpriseYieldSales)
    {
        startPage();
        List<TeaEnterpriseYieldSales> list = teaEnterpriseYieldSalesService.selectTeaEnterpriseYieldSalesList(teaEnterpriseYieldSales);
        return getDataTable(list);
    }

    /**
     * 导出企业历年产量及销售情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseYieldSales:export')")
    @Log(title = "企业历年产量及销售情况", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaEnterpriseYieldSales teaEnterpriseYieldSales)
    {
        List<TeaEnterpriseYieldSales> list = teaEnterpriseYieldSalesService.selectTeaEnterpriseYieldSalesList(teaEnterpriseYieldSales);
        ExcelUtil<TeaEnterpriseYieldSales> util = new ExcelUtil<TeaEnterpriseYieldSales>(TeaEnterpriseYieldSales.class);
        return util.exportExcel(list, "企业历年产量及销售情况数据");
    }

    /**
     * 获取企业历年产量及销售情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseYieldSales:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaEnterpriseYieldSalesService.selectTeaEnterpriseYieldSalesById(id));
    }

    /**
     * 新增企业历年产量及销售情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseYieldSales:add')")
    @Log(title = "企业历年产量及销售情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaEnterpriseYieldSales teaEnterpriseYieldSales)
    {
        return toAjax(teaEnterpriseYieldSalesService.insertTeaEnterpriseYieldSales(teaEnterpriseYieldSales));
    }

    /**
     * 修改企业历年产量及销售情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseYieldSales:edit')")
    @Log(title = "企业历年产量及销售情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaEnterpriseYieldSales teaEnterpriseYieldSales)
    {
        return toAjax(teaEnterpriseYieldSalesService.updateTeaEnterpriseYieldSales(teaEnterpriseYieldSales));
    }

    /**
     * 删除企业历年产量及销售情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaEnterpriseYieldSales:remove')")
    @Log(title = "企业历年产量及销售情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaEnterpriseYieldSalesService.deleteTeaEnterpriseYieldSalesByIds(ids));
    }
}
