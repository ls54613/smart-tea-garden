package com.wanou.project.system.controller;

import java.util.List;

import com.wanou.project.system.domain.vo.TeaGardenVo;
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
import com.wanou.project.system.domain.TeaGarden;
import com.wanou.project.system.service.ITeaGardenService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2022-03-03
 */
@RestController
@RequestMapping("/system/garden")
public class TeaGardenController extends BaseController
{
    @Autowired
    private ITeaGardenService teaGardenService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:garden:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaGarden teaGarden)
    {
        startPage();
        List<TeaGarden> list = teaGardenService.selectTeaGardenList(teaGarden);
        return getDataTable(list);
    }

    /**
     * 获取所有茶园
     * @param teaGarden
     * @return
     */
    @GetMapping("/listAll")
    public AjaxResult listAll(TeaGarden teaGarden){
        List<TeaGarden> list = teaGardenService.selectTeaGardenList(teaGarden);
        return AjaxResult.success(list);
    }


    @PreAuthorize("@ss.hasPermi('system:garden:list')")
    @GetMapping("/listTeaGarden")
    public TableDataInfo listTeaGarden(TeaGarden teaGarden)
    {
        startPage();
        List<TeaGardenVo> list = teaGardenService.listTeaGarden(teaGarden);
        return getDataTable(list);
    }



    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:garden:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaGarden teaGarden)
    {
        List<TeaGarden> list = teaGardenService.selectTeaGardenList(teaGarden);
        ExcelUtil<TeaGarden> util = new ExcelUtil<TeaGarden>(TeaGarden.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:garden:query')")
    @GetMapping(value = "/{teaGardenId}")
    public AjaxResult getInfo(@PathVariable("teaGardenId") Long teaGardenId)
    {
        return AjaxResult.success(teaGardenService.selectTeaGardenByTeaGardenId(teaGardenId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:garden:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaGarden teaGarden)
    {
        return toAjax(teaGardenService.insertTeaGarden(teaGarden));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:garden:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaGarden teaGarden)
    {
        return toAjax(teaGardenService.updateTeaGarden(teaGarden));
    }


    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:garden:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teaGardenIds}")
    public AjaxResult remove(@PathVariable Long[] teaGardenIds)
    {
        return toAjax(teaGardenService.deleteTeaGardenByTeaGardenIds(teaGardenIds));
    }
}
