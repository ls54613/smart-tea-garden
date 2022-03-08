package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaPeasantYieldSalesMapper;
import com.wanou.project.system.domain.TeaPeasantYieldSales;
import com.wanou.project.system.service.ITeaPeasantYieldSalesService;

/**
 * 茶农个人历年销量及销售额统计Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-05
 */
@Service
public class TeaPeasantYieldSalesServiceImpl implements ITeaPeasantYieldSalesService
{
    @Autowired
    private TeaPeasantYieldSalesMapper teaPeasantYieldSalesMapper;

    /**
     * 查询茶农个人历年销量及销售额统计
     *
     * @param id 茶农个人历年销量及销售额统计主键
     * @return 茶农个人历年销量及销售额统计
     */
    @Override
    public TeaPeasantYieldSales selectTeaPeasantYieldSalesById(Long id)
    {
        return teaPeasantYieldSalesMapper.selectTeaPeasantYieldSalesById(id);
    }

    /**
     * 查询茶农个人历年销量及销售额统计列表
     *
     * @param teaPeasantYieldSales 茶农个人历年销量及销售额统计
     * @return 茶农个人历年销量及销售额统计
     */
    @Override
    public List<TeaPeasantYieldSales> selectTeaPeasantYieldSalesList(TeaPeasantYieldSales teaPeasantYieldSales)
    {
        return teaPeasantYieldSalesMapper.selectTeaPeasantYieldSalesList(teaPeasantYieldSales);
    }

    /**
     * 新增茶农个人历年销量及销售额统计
     *
     * @param teaPeasantYieldSales 茶农个人历年销量及销售额统计
     * @return 结果
     */
    @Override
    public int insertTeaPeasantYieldSales(TeaPeasantYieldSales teaPeasantYieldSales)
    {
        return teaPeasantYieldSalesMapper.insertTeaPeasantYieldSales(teaPeasantYieldSales);
    }

    /**
     * 修改茶农个人历年销量及销售额统计
     *
     * @param teaPeasantYieldSales 茶农个人历年销量及销售额统计
     * @return 结果
     */
    @Override
    public int updateTeaPeasantYieldSales(TeaPeasantYieldSales teaPeasantYieldSales)
    {
        return teaPeasantYieldSalesMapper.updateTeaPeasantYieldSales(teaPeasantYieldSales);
    }

    /**
     * 批量删除茶农个人历年销量及销售额统计
     *
     * @param ids 需要删除的茶农个人历年销量及销售额统计主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantYieldSalesByIds(Long[] ids)
    {
        return teaPeasantYieldSalesMapper.deleteTeaPeasantYieldSalesByIds(ids);
    }

    /**
     * 删除茶农个人历年销量及销售额统计信息
     *
     * @param id 茶农个人历年销量及销售额统计主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantYieldSalesById(Long id)
    {
        return teaPeasantYieldSalesMapper.deleteTeaPeasantYieldSalesById(id);
    }
}
