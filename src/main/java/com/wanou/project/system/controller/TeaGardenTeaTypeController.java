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
import com.wanou.project.system.domain.TeaGardenTeaType;
import com.wanou.project.system.service.ITeaGardenTeaTypeService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶园种植种类占比Controller
 *
 * @author ruoyi
 * @date 2022-03-14
 */
@RestController
@RequestMapping("/system/teaGardenTeaType")
public class TeaGardenTeaTypeController extends BaseController
{
    @Autowired
    private ITeaGardenTeaTypeService teaGardenTeaTypeService;

    /**
     * 查询茶园种植种类占比列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenTeaType:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaGardenTeaType teaGardenTeaType)
    {
        startPage();
        List<TeaGardenTeaType> list = teaGardenTeaTypeService.selectTeaGardenTeaTypeList(teaGardenTeaType);
        return getDataTable(list);
    }

    /**
     * 导出茶园种植种类占比列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenTeaType:export')")
    @Log(title = "茶园种植种类占比", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaGardenTeaType teaGardenTeaType)
    {
        List<TeaGardenTeaType> list = teaGardenTeaTypeService.selectTeaGardenTeaTypeList(teaGardenTeaType);
        ExcelUtil<TeaGardenTeaType> util = new ExcelUtil<TeaGardenTeaType>(TeaGardenTeaType.class);
        return util.exportExcel(list, "茶园种植种类占比数据");
    }

    /**
     * 获取茶园种植种类占比详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenTeaType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaGardenTeaTypeService.selectTeaGardenTeaTypeById(id));
    }

    /**
     * 新增茶园种植种类占比
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenTeaType:add')")
    @Log(title = "茶园种植种类占比", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaGardenTeaType teaGardenTeaType)
    {
        return toAjax(teaGardenTeaTypeService.insertTeaGardenTeaType(teaGardenTeaType));
    }

    /**
     * 修改茶园种植种类占比
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenTeaType:edit')")
    @Log(title = "茶园种植种类占比", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaGardenTeaType teaGardenTeaType)
    {
        return toAjax(teaGardenTeaTypeService.updateTeaGardenTeaType(teaGardenTeaType));
    }

    /**
     * 删除茶园种植种类占比
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenTeaType:remove')")
    @Log(title = "茶园种植种类占比", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaGardenTeaTypeService.deleteTeaGardenTeaTypeByIds(ids));
    }
}
