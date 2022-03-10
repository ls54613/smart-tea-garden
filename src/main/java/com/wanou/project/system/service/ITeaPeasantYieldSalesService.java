package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaPeasantYieldSales;

/**
 * 茶农个人历年销量及销售额统计Service接口
 *
 * @author ruoyi
 * @date 2022-03-05
 */
public interface ITeaPeasantYieldSalesService
{
    /**
     * 查询茶农个人历年销量及销售额统计
     *
     * @param id 茶农个人历年销量及销售额统计主键
     * @return 茶农个人历年销量及销售额统计
     */
    public TeaPeasantYieldSales selectTeaPeasantYieldSalesById(Long id);

    /**
     * 查询茶农个人历年销量及销售额统计列表
     *
     * @param teaPeasantYieldSales 茶农个人历年销量及销售额统计
     * @return 茶农个人历年销量及销售额统计集合
     */
    public List<TeaPeasantYieldSales> selectTeaPeasantYieldSalesList(TeaPeasantYieldSales teaPeasantYieldSales);

    /**
     * 新增茶农个人历年销量及销售额统计
     *
     * @param teaPeasantYieldSales 茶农个人历年销量及销售额统计
     * @return 结果
     */
    public int insertTeaPeasantYieldSales(TeaPeasantYieldSales teaPeasantYieldSales);

    /**
     * 修改茶农个人历年销量及销售额统计
     *
     * @param teaPeasantYieldSales 茶农个人历年销量及销售额统计
     * @return 结果
     */
    public int updateTeaPeasantYieldSales(TeaPeasantYieldSales teaPeasantYieldSales);

    /**
     * 批量删除茶农个人历年销量及销售额统计
     *
     * @param ids 需要删除的茶农个人历年销量及销售额统计主键集合
     * @return 结果
     */
    public int deleteTeaPeasantYieldSalesByIds(Long[] ids);

    /**
     * 删除茶农个人历年销量及销售额统计信息
     *
     * @param id 茶农个人历年销量及销售额统计主键
     * @return 结果
     */
    public int deleteTeaPeasantYieldSalesById(Long id);

    public List<TeaPeasantYieldSales> getYieldValueNumber(long teaPeasantId);

    public List<TeaPeasantYieldSales> getYieldValueMoney(long teaPeasantId);
}
