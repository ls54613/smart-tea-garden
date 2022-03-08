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
import com.wanou.project.system.domain.TeaPeasantYieldSales;
import com.wanou.project.system.service.ITeaPeasantYieldSalesService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶农个人历年销量及销售额统计Controller
 *
 * @author ruoyi
 * @date 2022-03-05
 */
@RestController
@RequestMapping("/system/teaPeasantYieldSales")
public class TeaPeasantYieldSalesController extends BaseController
{
    @Autowired
    private ITeaPeasantYieldSalesService teaPeasantYieldSalesService;

    /**
     * 查询茶农个人历年销量及销售额统计列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantYieldSales:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaPeasantYieldSales teaPeasantYieldSales)
    {
        startPage();
        List<TeaPeasantYieldSales> list = teaPeasantYieldSalesService.selectTeaPeasantYieldSalesList(teaPeasantYieldSales);
        return getDataTable(list);
    }

    /**
     * 导出茶农个人历年销量及销售额统计列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantYieldSales:export')")
    @Log(title = "茶农个人历年销量及销售额统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaPeasantYieldSales teaPeasantYieldSales)
    {
        List<TeaPeasantYieldSales> list = teaPeasantYieldSalesService.selectTeaPeasantYieldSalesList(teaPeasantYieldSales);
        ExcelUtil<TeaPeasantYieldSales> util = new ExcelUtil<TeaPeasantYieldSales>(TeaPeasantYieldSales.class);
        return util.exportExcel(list, "茶农个人历年销量及销售额统计数据");
    }

    /**
     * 获取茶农个人历年销量及销售额统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantYieldSales:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaPeasantYieldSalesService.selectTeaPeasantYieldSalesById(id));
    }

    /**
     * 新增茶农个人历年销量及销售额统计
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantYieldSales:add')")
    @Log(title = "茶农个人历年销量及销售额统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaPeasantYieldSales teaPeasantYieldSales)
    {
        return toAjax(teaPeasantYieldSalesService.insertTeaPeasantYieldSales(teaPeasantYieldSales));
    }

    /**
     * 修改茶农个人历年销量及销售额统计
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantYieldSales:edit')")
    @Log(title = "茶农个人历年销量及销售额统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaPeasantYieldSales teaPeasantYieldSales)
    {
        return toAjax(teaPeasantYieldSalesService.updateTeaPeasantYieldSales(teaPeasantYieldSales));
    }

    /**
     * 删除茶农个人历年销量及销售额统计
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantYieldSales:remove')")
    @Log(title = "茶农个人历年销量及销售额统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaPeasantYieldSalesService.deleteTeaPeasantYieldSalesByIds(ids));
    }
}
