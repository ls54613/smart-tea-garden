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
import com.wanou.project.system.domain.TeaPeasantFamily;
import com.wanou.project.system.service.ITeaPeasantFamilyService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶农家庭成员Controller
 *
 * @author MrYao
 * @date 2022-03-03
 */
@RestController
@RequestMapping("/system/teaPeasantFamily")
public class TeaPeasantFamilyController extends BaseController
{
    @Autowired
    private ITeaPeasantFamilyService teaPeasantFamilyService;

    /**
     * 查询茶农家庭成员列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantFamily:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaPeasantFamily teaPeasantFamily)
    {
        startPage();
        List<TeaPeasantFamily> list = teaPeasantFamilyService.selectTeaPeasantFamilyList(teaPeasantFamily);
        return getDataTable(list);
    }

    /**
     * 导出茶农家庭成员列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantFamily:export')")
    @Log(title = "茶农家庭成员", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaPeasantFamily teaPeasantFamily)
    {
        List<TeaPeasantFamily> list = teaPeasantFamilyService.selectTeaPeasantFamilyList(teaPeasantFamily);
        ExcelUtil<TeaPeasantFamily> util = new ExcelUtil<TeaPeasantFamily>(TeaPeasantFamily.class);
        return util.exportExcel(list, "茶农家庭成员数据");
    }

    /**
     * 获取茶农家庭成员详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantFamily:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaPeasantFamilyService.selectTeaPeasantFamilyById(id));
    }

    /**
     * 新增茶农家庭成员
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantFamily:add')")
    @Log(title = "茶农家庭成员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaPeasantFamily teaPeasantFamily)
    {
        return toAjax(teaPeasantFamilyService.insertTeaPeasantFamily(teaPeasantFamily));
    }

    /**
     * 修改茶农家庭成员
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantFamily:edit')")
    @Log(title = "茶农家庭成员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaPeasantFamily teaPeasantFamily)
    {
        return toAjax(teaPeasantFamilyService.updateTeaPeasantFamily(teaPeasantFamily));
    }

    /**
     * 删除茶农家庭成员
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantFamily:remove')")
    @Log(title = "茶农家庭成员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaPeasantFamilyService.deleteTeaPeasantFamilyByIds(ids));
    }
}
