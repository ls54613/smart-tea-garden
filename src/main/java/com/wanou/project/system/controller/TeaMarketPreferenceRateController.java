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
import com.wanou.project.system.domain.TeaMarketPreferenceRate;
import com.wanou.project.system.service.ITeaMarketPreferenceRateService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 中国茶叶线上销售品类数据监测Controller
 *
 * @author ruoyi
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/system/teaMarketPreferenceRate")
public class TeaMarketPreferenceRateController extends BaseController
{
    @Autowired
    private ITeaMarketPreferenceRateService teaMarketPreferenceRateService;

    /**
     * 查询中国茶叶线上销售品类数据监测列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketPreferenceRate:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaMarketPreferenceRate teaMarketPreferenceRate)
    {
        startPage();
        List<TeaMarketPreferenceRate> list = teaMarketPreferenceRateService.selectTeaMarketPreferenceRateList(teaMarketPreferenceRate);
        return getDataTable(list);
    }

    /**
     * 导出中国茶叶线上销售品类数据监测列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketPreferenceRate:export')")
    @Log(title = "中国茶叶线上销售品类数据监测", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaMarketPreferenceRate teaMarketPreferenceRate)
    {
        List<TeaMarketPreferenceRate> list = teaMarketPreferenceRateService.selectTeaMarketPreferenceRateList(teaMarketPreferenceRate);
        ExcelUtil<TeaMarketPreferenceRate> util = new ExcelUtil<TeaMarketPreferenceRate>(TeaMarketPreferenceRate.class);
        return util.exportExcel(list, "中国茶叶线上销售品类数据监测数据");
    }

    /**
     * 获取中国茶叶线上销售品类数据监测详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketPreferenceRate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaMarketPreferenceRateService.selectTeaMarketPreferenceRateById(id));
    }

    /**
     * 新增中国茶叶线上销售品类数据监测
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketPreferenceRate:add')")
    @Log(title = "中国茶叶线上销售品类数据监测", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaMarketPreferenceRate teaMarketPreferenceRate)
    {
        return toAjax(teaMarketPreferenceRateService.insertTeaMarketPreferenceRate(teaMarketPreferenceRate));
    }

    /**
     * 修改中国茶叶线上销售品类数据监测
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketPreferenceRate:edit')")
    @Log(title = "中国茶叶线上销售品类数据监测", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaMarketPreferenceRate teaMarketPreferenceRate)
    {
        return toAjax(teaMarketPreferenceRateService.updateTeaMarketPreferenceRate(teaMarketPreferenceRate));
    }

    /**
     * 删除中国茶叶线上销售品类数据监测
     */
    @PreAuthorize("@ss.hasPermi('system:teaMarketPreferenceRate:remove')")
    @Log(title = "中国茶叶线上销售品类数据监测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaMarketPreferenceRateService.deleteTeaMarketPreferenceRateByIds(ids));
    }
}
