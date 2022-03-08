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
import com.wanou.project.system.domain.TeaWarehouseCurrentValue;
import com.wanou.project.system.service.ITeaWarehouseCurrentValueService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 当前库存情况货值分布Controller
 *
 * @author ruoyi
 * @date 2022-03-07
 */
@RestController
@RequestMapping("/system/teaWarehouseCurrentValue")
public class TeaWarehouseCurrentValueController extends BaseController
{
    @Autowired
    private ITeaWarehouseCurrentValueService teaWarehouseCurrentValueService;

    /**
     * 查询当前库存情况货值分布列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaWarehouseCurrentValue:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaWarehouseCurrentValue teaWarehouseCurrentValue)
    {
        startPage();
        List<TeaWarehouseCurrentValue> list = teaWarehouseCurrentValueService.selectTeaWarehouseCurrentValueList(teaWarehouseCurrentValue);
        return getDataTable(list);
    }

    /**
     * 导出当前库存情况货值分布列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaWarehouseCurrentValue:export')")
    @Log(title = "当前库存情况货值分布", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaWarehouseCurrentValue teaWarehouseCurrentValue)
    {
        List<TeaWarehouseCurrentValue> list = teaWarehouseCurrentValueService.selectTeaWarehouseCurrentValueList(teaWarehouseCurrentValue);
        ExcelUtil<TeaWarehouseCurrentValue> util = new ExcelUtil<TeaWarehouseCurrentValue>(TeaWarehouseCurrentValue.class);
        return util.exportExcel(list, "当前库存情况货值分布数据");
    }

    /**
     * 获取当前库存情况货值分布详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaWarehouseCurrentValue:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaWarehouseCurrentValueService.selectTeaWarehouseCurrentValueById(id));
    }

    /**
     * 新增当前库存情况货值分布
     */
    @PreAuthorize("@ss.hasPermi('system:teaWarehouseCurrentValue:add')")
    @Log(title = "当前库存情况货值分布", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaWarehouseCurrentValue teaWarehouseCurrentValue)
    {
        return toAjax(teaWarehouseCurrentValueService.insertTeaWarehouseCurrentValue(teaWarehouseCurrentValue));
    }

    /**
     * 修改当前库存情况货值分布
     */
    @PreAuthorize("@ss.hasPermi('system:teaWarehouseCurrentValue:edit')")
    @Log(title = "当前库存情况货值分布", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaWarehouseCurrentValue teaWarehouseCurrentValue)
    {
        return toAjax(teaWarehouseCurrentValueService.updateTeaWarehouseCurrentValue(teaWarehouseCurrentValue));
    }

    /**
     * 删除当前库存情况货值分布
     */
    @PreAuthorize("@ss.hasPermi('system:teaWarehouseCurrentValue:remove')")
    @Log(title = "当前库存情况货值分布", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaWarehouseCurrentValueService.deleteTeaWarehouseCurrentValueByIds(ids));
    }
}
