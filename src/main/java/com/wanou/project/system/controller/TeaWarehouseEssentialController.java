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
import com.wanou.project.system.domain.TeaWarehouseEssential;
import com.wanou.project.system.service.ITeaWarehouseEssentialService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶仓基本情况Controller
 *
 * @author ruoyi
 * @date 2022-03-07
 */
@RestController
@RequestMapping("/system/TeaWarehouseEssential")
public class TeaWarehouseEssentialController extends BaseController
{
    @Autowired
    private ITeaWarehouseEssentialService teaWarehouseEssentialService;

    /**
     * 查询茶仓基本情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:TeaWarehouseEssential:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaWarehouseEssential teaWarehouseEssential)
    {
        startPage();
        List<TeaWarehouseEssential> list = teaWarehouseEssentialService.selectTeaWarehouseEssentialList(teaWarehouseEssential);
        return getDataTable(list);
    }


    @GetMapping("/findAllTeaWarehouse")
    public AjaxResult findAllTeaworehouseEssential(TeaWarehouseEssential teaWarehouseEssential){
        return AjaxResult.success(teaWarehouseEssentialService.selectTeaWarehouseEssentialList(teaWarehouseEssential));
    }
    /**
     * 导出茶仓基本情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:TeaWarehouseEssential:export')")
    @Log(title = "茶仓基本情况", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaWarehouseEssential teaWarehouseEssential)
    {
        List<TeaWarehouseEssential> list = teaWarehouseEssentialService.selectTeaWarehouseEssentialList(teaWarehouseEssential);
        ExcelUtil<TeaWarehouseEssential> util = new ExcelUtil<TeaWarehouseEssential>(TeaWarehouseEssential.class);
        return util.exportExcel(list, "茶仓基本情况数据");
    }

    /**
     * 获取茶仓基本情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:TeaWarehouseEssential:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaWarehouseEssentialService.selectTeaWarehouseEssentialById(id));
    }

    /**
     * 新增茶仓基本情况
     */
    @PreAuthorize("@ss.hasPermi('system:TeaWarehouseEssential:add')")
    @Log(title = "茶仓基本情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaWarehouseEssential teaWarehouseEssential)
    {
        return toAjax(teaWarehouseEssentialService.insertTeaWarehouseEssential(teaWarehouseEssential));
    }

    /**
     * 修改茶仓基本情况
     */
    @PreAuthorize("@ss.hasPermi('system:TeaWarehouseEssential:edit')")
    @Log(title = "茶仓基本情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaWarehouseEssential teaWarehouseEssential)
    {
        return toAjax(teaWarehouseEssentialService.updateTeaWarehouseEssential(teaWarehouseEssential));
    }

    /**
     * 删除茶仓基本情况
     */
    @PreAuthorize("@ss.hasPermi('system:TeaWarehouseEssential:remove')")
    @Log(title = "茶仓基本情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaWarehouseEssentialService.deleteTeaWarehouseEssentialByIds(ids));
    }
}
