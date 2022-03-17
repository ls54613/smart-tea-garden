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
import com.wanou.project.system.domain.TeaGardenDisease;
import com.wanou.project.system.service.ITeaGardenDiseaseService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 病虫害分析Controller
 *
 * @author txh
 * @date 2022-03-17
 */
@RestController
@RequestMapping("/system/teaGardenDisease")
public class TeaGardenDiseaseController extends BaseController
{
    @Autowired
    private ITeaGardenDiseaseService teaGardenDiseaseService;

    /**
     * 查询病虫害分析列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenDisease:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaGardenDisease teaGardenDisease)
    {
        startPage();
        List<TeaGardenDisease> list = teaGardenDiseaseService.selectTeaGardenDiseaseList(teaGardenDisease);
        return getDataTable(list);
    }

    /**
     * 导出病虫害分析列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenDisease:export')")
    @Log(title = "病虫害分析", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaGardenDisease teaGardenDisease)
    {
        List<TeaGardenDisease> list = teaGardenDiseaseService.selectTeaGardenDiseaseList(teaGardenDisease);
        ExcelUtil<TeaGardenDisease> util = new ExcelUtil<TeaGardenDisease>(TeaGardenDisease.class);
        return util.exportExcel(list, "病虫害分析数据");
    }

    /**
     * 获取病虫害分析详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenDisease:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaGardenDiseaseService.selectTeaGardenDiseaseById(id));
    }

    /**
     * 新增病虫害分析
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenDisease:add')")
    @Log(title = "病虫害分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaGardenDisease teaGardenDisease)
    {
        return toAjax(teaGardenDiseaseService.insertTeaGardenDisease(teaGardenDisease));
    }

    /**
     * 修改病虫害分析
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenDisease:edit')")
    @Log(title = "病虫害分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaGardenDisease teaGardenDisease)
    {
        return toAjax(teaGardenDiseaseService.updateTeaGardenDisease(teaGardenDisease));
    }

    /**
     * 删除病虫害分析
     */
    @PreAuthorize("@ss.hasPermi('system:teaGardenDisease:remove')")
    @Log(title = "病虫害分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaGardenDiseaseService.deleteTeaGardenDiseaseByIds(ids));
    }
}
