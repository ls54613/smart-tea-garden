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
import com.wanou.project.system.domain.TeaPeasantAnnual;
import com.wanou.project.system.service.ITeaPeasantAnnualService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶农历年年收入Controller
 *
 * @author MrYao
 * @date 2022-03-04
 */
@RestController
@RequestMapping("/system/teaPeasantAnnual")
public class TeaPeasantAnnualController extends BaseController
{
    @Autowired
    private ITeaPeasantAnnualService teaPeasantAnnualService;

    /**
     * 查询茶农历年年收入列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAnnual:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaPeasantAnnual teaPeasantAnnual)
    {
        startPage();
        List<TeaPeasantAnnual> list = teaPeasantAnnualService.selectTeaPeasantAnnualList(teaPeasantAnnual);
        return getDataTable(list);
    }

    /**
     * 导出茶农历年年收入列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAnnual:export')")
    @Log(title = "茶农历年年收入", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaPeasantAnnual teaPeasantAnnual)
    {
        List<TeaPeasantAnnual> list = teaPeasantAnnualService.selectTeaPeasantAnnualList(teaPeasantAnnual);
        ExcelUtil<TeaPeasantAnnual> util = new ExcelUtil<TeaPeasantAnnual>(TeaPeasantAnnual.class);
        return util.exportExcel(list, "茶农历年年收入数据");
    }

    /**
     * 获取茶农历年年收入详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAnnual:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaPeasantAnnualService.selectTeaPeasantAnnualById(id));
    }

    /**
     * 新增茶农历年年收入
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAnnual:add')")
    @Log(title = "茶农历年年收入", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaPeasantAnnual teaPeasantAnnual)
    {
        return toAjax(teaPeasantAnnualService.insertTeaPeasantAnnual(teaPeasantAnnual));
    }

    /**
     * 修改茶农历年年收入
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAnnual:edit')")
    @Log(title = "茶农历年年收入", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaPeasantAnnual teaPeasantAnnual)
    {
        return toAjax(teaPeasantAnnualService.updateTeaPeasantAnnual(teaPeasantAnnual));
    }

    /**
     * 删除茶农历年年收入
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAnnual:remove')")
    @Log(title = "茶农历年年收入", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaPeasantAnnualService.deleteTeaPeasantAnnualByIds(ids));
    }
}
