package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaPeasantIncome;

/**
 * 种植大户收入Service接口
 * 
 * @author ruoyi
 * @date 2022-04-02
 */
public interface ITeaPeasantIncomeService 
{
    /**
     * 查询种植大户收入
     * 
     * @param id 种植大户收入主键
     * @return 种植大户收入
     */
    public TeaPeasantIncome selectTeaPeasantIncomeById(Long id);

    /**
     * 查询种植大户收入列表
     * 
     * @param teaPeasantIncome 种植大户收入
     * @return 种植大户收入集合
     */
    public List<TeaPeasantIncome> selectTeaPeasantIncomeList(TeaPeasantIncome teaPeasantIncome);

    /**
     * 新增种植大户收入
     * 
     * @param teaPeasantIncome 种植大户收入
     * @return 结果
     */
    public int insertTeaPeasantIncome(TeaPeasantIncome teaPeasantIncome);

    /**
     * 修改种植大户收入
     * 
     * @param teaPeasantIncome 种植大户收入
     * @return 结果
     */
    public int updateTeaPeasantIncome(TeaPeasantIncome teaPeasantIncome);

    /**
     * 批量删除种植大户收入
     * 
     * @param ids 需要删除的种植大户收入主键集合
     * @return 结果
     */
    public int deleteTeaPeasantIncomeByIds(Long[] ids);

    /**
     * 删除种植大户收入信息
     * 
     * @param id 种植大户收入主键
     * @return 结果
     */
    public int deleteTeaPeasantIncomeById(Long id);
}
