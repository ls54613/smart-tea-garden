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
import com.wanou.project.system.domain.TeaMarketYear;
import com.wanou.project.system.service.ITeaMarketYearService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶市基本情况表Controller
 *
 * @author ruoyi
 * @date 2022-04-02
 */
@RestController
@RequestMapping("/system/teaMarketYear")
public class TeaMarketYearController extends BaseController
{
    @Autowired
    private ITeaMarketYearService teaMarketYearService;

    /**
     * 查询茶市基本情况表列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketYear:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaMarketYear teaMarketYear)
    {
        startPage();
        List<TeaMarketYear> list = teaMarketYearService.selectTeaMarketYearList(teaMarketYear);
        return getDataTable(list);
    }

    /**
     * 导出茶市基本情况表列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketYear:export')")
    @Log(title = "茶市基本情况表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaMarketYear teaMarketYear)
    {
        List<TeaMarketYear> list = teaMarketYearService.selectTeaMarketYearList(teaMarketYear);
        ExcelUtil<TeaMarketYear> util = new ExcelUtil<TeaMarketYear>(TeaMarketYear.class);
        return util.exportExcel(list, "茶市基本情况表数据");
    }

    /**
     * 获取茶市基本情况表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketYear:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaMarketYearService.selectTeaMarketYearById(id));
    }

    /**
     * 新增茶市基本情况表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketYear:add')")
    @Log(title = "茶市基本情况表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaMarketYear teaMarketYear)
    {
        return toAjax(teaMarketYearService.insertTeaMarketYear(teaMarketYear));
    }

    /**
     * 修改茶市基本情况表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketYear:edit')")
    @Log(title = "茶市基本情况表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaMarketYear teaMarketYear)
    {
        return toAjax(teaMarketYearService.updateTeaMarketYear(teaMarketYear));
    }

    /**
     * 删除茶市基本情况表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketYear:remove')")
    @Log(title = "茶市基本情况表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaMarketYearService.deleteTeaMarketYearByIds(ids));
    }
}
