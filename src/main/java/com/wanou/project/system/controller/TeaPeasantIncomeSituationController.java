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
 * 常宁茶农人均收入与总体人均收入Controller
 *
 * @author ruoyi
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/system/teaPeasantIncomeSituation")
public class TeaPeasantIncomeSituationController extends BaseController
{
    @Autowired
    private ITeaPeasantIncomeSituationService teaPeasantIncomeSituationService;

    /**
     * 查询常宁茶农人均收入与总体人均收入列表
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
     * 导出常宁茶农人均收入与总体人均收入列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:export')")
    @Log(title = "常宁茶农人均收入与总体人均收入", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        List<TeaPeasantIncomeSituation> list = teaPeasantIncomeSituationService.selectTeaPeasantIncomeSituationList(teaPeasantIncomeSituation);
        ExcelUtil<TeaPeasantIncomeSituation> util = new ExcelUtil<TeaPeasantIncomeSituation>(TeaPeasantIncomeSituation.class);
        return util.exportExcel(list, "常宁茶农人均收入与总体人均收入数据");
    }

    /**
     * 获取常宁茶农人均收入与总体人均收入详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaPeasantIncomeSituationService.selectTeaPeasantIncomeSituationById(id));
    }

    /**
     * 新增常宁茶农人均收入与总体人均收入
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:add')")
    @Log(title = "常宁茶农人均收入与总体人均收入", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        return toAjax(teaPeasantIncomeSituationService.insertTeaPeasantIncomeSituation(teaPeasantIncomeSituation));
    }

    /**
     * 修改常宁茶农人均收入与总体人均收入
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:edit')")
    @Log(title = "常宁茶农人均收入与总体人均收入", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        return toAjax(teaPeasantIncomeSituationService.updateTeaPeasantIncomeSituation(teaPeasantIncomeSituation));
    }

    /**
     * 删除常宁茶农人均收入与总体人均收入
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantIncomeSituation:remove')")
    @Log(title = "常宁茶农人均收入与总体人均收入", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaPeasantIncomeSituationService.deleteTeaPeasantIncomeSituationByIds(ids));
    }
}
