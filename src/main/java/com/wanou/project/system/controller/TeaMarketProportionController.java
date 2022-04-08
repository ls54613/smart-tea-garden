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
import com.wanou.project.system.domain.TeaMarketProportion;
import com.wanou.project.system.service.ITeaMarketProportionService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 2021年各品种产量占比情况Controller
 *
 * @author ruoyi
 * @date 2022-04-02
 */
@RestController
@RequestMapping("/system/teaMarketProportion")
public class TeaMarketProportionController extends BaseController
{
    @Autowired
    private ITeaMarketProportionService teaMarketProportionService;

    /**
     * 查询2021年各品种产量占比情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketProportion:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaMarketProportion teaMarketProportion)
    {
        startPage();
        List<TeaMarketProportion> list = teaMarketProportionService.selectTeaMarketProportionList(teaMarketProportion);
        return getDataTable(list);
    }

    /**
     * 导出2021年各品种产量占比情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketProportion:export')")
    @Log(title = "2021年各品种产量占比情况", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaMarketProportion teaMarketProportion)
    {
        List<TeaMarketProportion> list = teaMarketProportionService.selectTeaMarketProportionList(teaMarketProportion);
        ExcelUtil<TeaMarketProportion> util = new ExcelUtil<TeaMarketProportion>(TeaMarketProportion.class);
        return util.exportExcel(list, "2021年各品种产量占比情况数据");
    }

    /**
     * 获取2021年各品种产量占比情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketProportion:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaMarketProportionService.selectTeaMarketProportionById(id));
    }

    /**
     * 新增2021年各品种产量占比情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketProportion:add')")
    @Log(title = "2021年各品种产量占比情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaMarketProportion teaMarketProportion)
    {
        return toAjax(teaMarketProportionService.insertTeaMarketProportion(teaMarketProportion));
    }

    /**
     * 修改2021年各品种产量占比情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketProportion:edit')")
    @Log(title = "2021年各品种产量占比情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaMarketProportion teaMarketProportion)
    {
        return toAjax(teaMarketProportionService.updateTeaMarketProportion(teaMarketProportion));
    }

    /**
     * 删除2021年各品种产量占比情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketProportion:remove')")
    @Log(title = "2021年各品种产量占比情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaMarketProportionService.deleteTeaMarketProportionByIds(ids));
    }
}
