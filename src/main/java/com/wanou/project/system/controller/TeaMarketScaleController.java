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
import com.wanou.project.system.domain.TeaMarketScale;
import com.wanou.project.system.service.ITeaMarketScaleService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 中国茶叶线上销售规模监测数据Controller
 *
 * @author MrYao
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/system/teaMarketScale")
public class TeaMarketScaleController extends BaseController
{
    @Autowired
    private ITeaMarketScaleService teaMarketScaleService;

    /**
     * 查询中国茶叶线上销售规模监测数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketScale:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaMarketScale teaMarketScale)
    {
        startPage();
        List<TeaMarketScale> list = teaMarketScaleService.selectTeaMarketScaleList(teaMarketScale);
        return getDataTable(list);
    }

    /**
     * 导出中国茶叶线上销售规模监测数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketScale:export')")
    @Log(title = "中国茶叶线上销售规模监测数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaMarketScale teaMarketScale)
    {
        List<TeaMarketScale> list = teaMarketScaleService.selectTeaMarketScaleList(teaMarketScale);
        ExcelUtil<TeaMarketScale> util = new ExcelUtil<TeaMarketScale>(TeaMarketScale.class);
        return util.exportExcel(list, "中国茶叶线上销售规模监测数据数据");
    }

    /**
     * 获取中国茶叶线上销售规模监测数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketScale:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaMarketScaleService.selectTeaMarketScaleById(id));
    }

    /**
     * 新增中国茶叶线上销售规模监测数据
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketScale:add')")
    @Log(title = "中国茶叶线上销售规模监测数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaMarketScale teaMarketScale)
    {
        return toAjax(teaMarketScaleService.insertTeaMarketScale(teaMarketScale));
    }

    /**
     * 修改中国茶叶线上销售规模监测数据
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketScale:edit')")
    @Log(title = "中国茶叶线上销售规模监测数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaMarketScale teaMarketScale)
    {
        return toAjax(teaMarketScaleService.updateTeaMarketScale(teaMarketScale));
    }

    /**
     * 删除中国茶叶线上销售规模监测数据
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketScale:remove')")
    @Log(title = "中国茶叶线上销售规模监测数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaMarketScaleService.deleteTeaMarketScaleByIds(ids));
    }
}
