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
import com.wanou.project.system.domain.TeaPeasantIncomeSituation;
import com.wanou.project.system.service.ITeaPeasantIncomeSituationService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 人均收入情况Controller
 *
 * @author ruoyi
 * @date 2022-04-02
 */
@RestController
@RequestMapping("/system/teaPeasantIncomeSituation")
public class TeaPeasantIncomeSituationController extends BaseController
{
    @Autowired
    private ITeaPeasantIncomeSituationService teaPeasantIncomeSituationService;

    /**
     * 查询人均收入情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        startPage();
        List<TeaPeasantIncomeSituation> list = teaPeasantIncomeSituationService.selectTeaPeasantIncomeSituationList(teaPeasantIncomeSituation);
        return getDataTable(list);
    }

    /**
     * 导出人均收入情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:export')")
    @Log(title = "人均收入情况", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        List<TeaPeasantIncomeSituation> list = teaPeasantIncomeSituationService.selectTeaPeasantIncomeSituationList(teaPeasantIncomeSituation);
        ExcelUtil<TeaPeasantIncomeSituation> util = new ExcelUtil<TeaPeasantIncomeSituation>(TeaPeasantIncomeSituation.class);
        return util.exportExcel(list, "人均收入情况数据");
    }

    /**
     * 获取人均收入情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaPeasantIncomeSituationService.selectTeaPeasantIncomeSituationById(id));
    }

    /**
     * 新增人均收入情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:add')")
    @Log(title = "人均收入情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        return toAjax(teaPeasantIncomeSituationService.insertTeaPeasantIncomeSituation(teaPeasantIncomeSituation));
    }

    /**
     * 修改人均收入情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:edit')")
    @Log(title = "人均收入情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        return toAjax(teaPeasantIncomeSituationService.updateTeaPeasantIncomeSituation(teaPeasantIncomeSituation));
    }

    /**
     * 删除人均收入情况
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:remove')")
    @Log(title = "人均收入情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaPeasantIncomeSituationService.deleteTeaPeasantIncomeSituationByIds(ids));
    }
}
