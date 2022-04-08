package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaPeasantIncomeMapper;
import com.wanou.project.system.domain.TeaPeasantIncome;
import com.wanou.project.system.service.ITeaPeasantIncomeService;

/**
 * 种植大户收入Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-06
 */
@Service
public class TeaPeasantIncomeServiceImpl implements ITeaPeasantIncomeService
{
    @Autowired
    private TeaPeasantIncomeMapper teaPeasantIncomeMapper;

    /**
     * 查询种植大户收入
     *
     * @param id 种植大户收入主键
     * @return 种植大户收入
     */
    @Override
    public TeaPeasantIncome selectTeaPeasantIncomeById(Long id)
    {
        return teaPeasantIncomeMapper.selectTeaPeasantIncomeById(id);
    }

    /**
     * 查询种植大户收入列表
     *
     * @param teaPeasantIncome 种植大户收入
     * @return 种植大户收入
     */
    @Override
    public List<TeaPeasantIncome> selectTeaPeasantIncomeList(TeaPeasantIncome teaPeasantIncome)
    {
        return teaPeasantIncomeMapper.selectTeaPeasantIncomeList(teaPeasantIncome);
    }

    /**
     * 新增种植大户收入
     *
     * @param teaPeasantIncome 种植大户收入
     * @return 结果
     */
    @Override
    public int insertTeaPeasantIncome(TeaPeasantIncome teaPeasantIncome)
    {
        return teaPeasantIncomeMapper.insertTeaPeasantIncome(teaPeasantIncome);
    }

    /**
     * 修改种植大户收入
     *
     * @param teaPeasantIncome 种植大户收入
     * @return 结果
     */
    @Override
    public int updateTeaPeasantIncome(TeaPeasantIncome teaPeasantIncome)
    {
        return teaPeasantIncomeMapper.updateTeaPeasantIncome(teaPeasantIncome);
    }

    /**
     * 批量删除种植大户收入
     *
     * @param ids 需要删除的种植大户收入主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantIncomeByIds(Long[] ids)
    {
        return teaPeasantIncomeMapper.deleteTeaPeasantIncomeByIds(ids);
    }

    /**
     * 删除种植大户收入信息
     *
     * @param id 种植大户收入主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantIncomeById(Long id)
    {
        return teaPeasantIncomeMapper.deleteTeaPeasantIncomeById(id);
    }
}
