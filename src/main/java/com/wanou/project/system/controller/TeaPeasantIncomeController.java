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
import com.wanou.project.system.domain.TeaPeasantIncome;
import com.wanou.project.system.service.ITeaPeasantIncomeService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 种植大户收入Controller
 *
 * @author ruoyi
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/system/teaPeasantIncome")
public class TeaPeasantIncomeController extends BaseController
{
    @Autowired
    private ITeaPeasantIncomeService teaPeasantIncomeService;

    /**
     * 查询种植大户收入列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncome:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaPeasantIncome teaPeasantIncome)
    {
        startPage();
        List<TeaPeasantIncome> list = teaPeasantIncomeService.selectTeaPeasantIncomeList(teaPeasantIncome);
        return getDataTable(list);
    }

    /**
     * 导出种植大户收入列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncome:export')")
    @Log(title = "种植大户收入", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaPeasantIncome teaPeasantIncome)
    {
        List<TeaPeasantIncome> list = teaPeasantIncomeService.selectTeaPeasantIncomeList(teaPeasantIncome);
        ExcelUtil<TeaPeasantIncome> util = new ExcelUtil<TeaPeasantIncome>(TeaPeasantIncome.class);
        return util.exportExcel(list, "种植大户收入数据");
    }

    /**
     * 获取种植大户收入详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncome:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaPeasantIncomeService.selectTeaPeasantIncomeById(id));
    }

    /**
     * 新增种植大户收入
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncome:add')")
    @Log(title = "种植大户收入", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaPeasantIncome teaPeasantIncome)
    {
        return toAjax(teaPeasantIncomeService.insertTeaPeasantIncome(teaPeasantIncome));
    }

    /**
     * 修改种植大户收入
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncome:edit')")
    @Log(title = "种植大户收入", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaPeasantIncome teaPeasantIncome)
    {
        return toAjax(teaPeasantIncomeService.updateTeaPeasantIncome(teaPeasantIncome));
    }

    /**
     * 删除种植大户收入
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncome:remove')")
    @Log(title = "种植大户收入", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaPeasantIncomeService.deleteTeaPeasantIncomeByIds(ids));
    }
}
