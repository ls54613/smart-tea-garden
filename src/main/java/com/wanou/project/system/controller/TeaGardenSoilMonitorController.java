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
import com.wanou.project.system.domain.TeaGardenSoilMonitor;
import com.wanou.project.system.service.ITeaGardenSoilMonitorService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶园土壤监测Controller
 *
 * @author txh
 * @date 2022-03-17
 */
@RestController
@RequestMapping("/system/teaGardenSoilMonitor")
public class TeaGardenSoilMonitorController extends BaseController
{
    @Autowired
    private ITeaGardenSoilMonitorService teaGardenSoilMonitorService;

    /**
     * 查询茶园土壤监测列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenSoilMonitor:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaGardenSoilMonitor teaGardenSoilMonitor)
    {
        startPage();
        List<TeaGardenSoilMonitor> list = teaGardenSoilMonitorService.selectTeaGardenSoilMonitorList(teaGardenSoilMonitor);
        return getDataTable(list);
    }

    /**
     * 导出茶园土壤监测列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenSoilMonitor:export')")
    @Log(title = "茶园土壤监测", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaGardenSoilMonitor teaGardenSoilMonitor)
    {
        List<TeaGardenSoilMonitor> list = teaGardenSoilMonitorService.selectTeaGardenSoilMonitorList(teaGardenSoilMonitor);
        ExcelUtil<TeaGardenSoilMonitor> util = new ExcelUtil<TeaGardenSoilMonitor>(TeaGardenSoilMonitor.class);
        return util.exportExcel(list, "茶园土壤监测数据");
    }

    /**
     * 获取茶园土壤监测详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenSoilMonitor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaGardenSoilMonitorService.selectTeaGardenSoilMonitorById(id));
    }

    /**
     * 新增茶园土壤监测
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenSoilMonitor:add')")
    @Log(title = "茶园土壤监测", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaGardenSoilMonitor teaGardenSoilMonitor)
    {
        return toAjax(teaGardenSoilMonitorService.insertTeaGardenSoilMonitor(teaGardenSoilMonitor));
    }

    /**
     * 修改茶园土壤监测
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenSoilMonitor:edit')")
    @Log(title = "茶园土壤监测", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaGardenSoilMonitor teaGardenSoilMonitor)
    {
        return toAjax(teaGardenSoilMonitorService.updateTeaGardenSoilMonitor(teaGardenSoilMonitor));
    }

    /**
     * 删除茶园土壤监测
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenSoilMonitor:remove')")
    @Log(title = "茶园土壤监测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaGardenSoilMonitorService.deleteTeaGardenSoilMonitorByIds(ids));
    }
}
