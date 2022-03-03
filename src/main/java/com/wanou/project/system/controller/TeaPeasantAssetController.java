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
import com.wanou.project.system.domain.TeaPeasantAsset;
import com.wanou.project.system.service.ITeaPeasantAssetService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 茶农资产状况Controller
 *
 * @author MrYao
 * @date 2022-03-02
 */
@RestController
@RequestMapping("/system/teaPeasantAsset")
public class TeaPeasantAssetController extends BaseController
{
    @Autowired
    private ITeaPeasantAssetService teaPeasantAssetService;

    /**
     * 查询茶农资产状况列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAsset:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaPeasantAsset teaPeasantAsset)
    {
        startPage();
        List<TeaPeasantAsset> list = teaPeasantAssetService.selectTeaPeasantAssetList(teaPeasantAsset);
        return getDataTable(list);
    }

    /**
     * 导出茶农资产状况列表
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAsset:export')")
    @Log(title = "茶农资产状况", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeaPeasantAsset teaPeasantAsset)
    {
        List<TeaPeasantAsset> list = teaPeasantAssetService.selectTeaPeasantAssetList(teaPeasantAsset);
        ExcelUtil<TeaPeasantAsset> util = new ExcelUtil<TeaPeasantAsset>(TeaPeasantAsset.class);
        return util.exportExcel(list, "茶农资产状况数据");
    }

    /**
     * 获取茶农资产状况详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAsset:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaPeasantAssetService.selectTeaPeasantAssetById(id));
    }

    /**
     * 新增茶农资产状况
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAsset:add')")
    @Log(title = "茶农资产状况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaPeasantAsset teaPeasantAsset)
    {
        return toAjax(teaPeasantAssetService.insertTeaPeasantAsset(teaPeasantAsset));
    }

    /**
     * 修改茶农资产状况
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAsset:edit')")
    @Log(title = "茶农资产状况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaPeasantAsset teaPeasantAsset)
    {
        return toAjax(teaPeasantAssetService.updateTeaPeasantAsset(teaPeasantAsset));
    }

    /**
     * 删除茶农资产状况
     */
    @PreAuthorize("@ss.hasPermi('system:teaPeasantAsset:remove')")
    @Log(title = "茶农资产状况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaPeasantAssetService.deleteTeaPeasantAssetByIds(ids));
    }
}
