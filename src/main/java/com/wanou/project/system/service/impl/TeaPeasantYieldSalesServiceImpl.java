package com.wanou.project.system.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.wanou.common.utils.DateUtils;
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

    @Override
    public List<TeaPeasantYieldSales> getYieldValueNumber(long teaPeasantId) {
        DateTime nowDate = DateUtil.date();
        DateTime startDate = DateUtil.offset(nowDate, DateField.YEAR, -5);
        DateTime endDate = DateUtil.offset(nowDate, DateField.YEAR, -1);
        List<TeaPeasantYieldSales> list = teaPeasantYieldSalesMapper.getYieldValueNumber(teaPeasantId, startDate, endDate);
        List<DateTime> dateTimes = DateUtil.rangeToList(startDate, endDate, DateField.YEAR);
        List<TeaPeasantYieldSales> result = new ArrayList<>(dateTimes.size());
        dateTimes.forEach(dateTime -> {
            TeaPeasantYieldSales one = CollUtil.findOne(list, (item -> String.valueOf(DateUtil.year(dateTime)).equals(item.getYear())));
            if(one != null){
                result.add(one);
            }else {
                TeaPeasantYieldSales teaPeasantYieldSales = new TeaPeasantYieldSales();
                teaPeasantYieldSales.setYear(String.valueOf(DateUtil.year(dateTime)));
                teaPeasantYieldSales.setYieldValueNumber(new BigDecimal(0));
                result.add(teaPeasantYieldSales);
            }
        });
        return result;
    }

    @Override
    public List<TeaPeasantYieldSales> getYieldValueMoney(long teaPeasantId) {
        DateTime nowDate = DateUtil.date();
        DateTime startDate = DateUtil.offset(nowDate, DateField.YEAR, -5);
        DateTime endDate = DateUtil.offset(nowDate, DateField.YEAR, -1);
        List<TeaPeasantYieldSales> list = teaPeasantYieldSalesMapper.getYieldValueMoney(teaPeasantId, startDate, endDate);
        List<DateTime> dateTimes = DateUtil.rangeToList(startDate, endDate, DateField.YEAR);
        List<TeaPeasantYieldSales> result = new ArrayList<>(dateTimes.size());
        dateTimes.forEach(dateTime -> {
            TeaPeasantYieldSales one = CollUtil.findOne(list, (item -> String.valueOf(DateUtil.year(dateTime)).equals(item.getYear())));
            if(one != null){
                result.add(one);
            }else {
                TeaPeasantYieldSales teaPeasantYieldSales = new TeaPeasantYieldSales();
                teaPeasantYieldSales.setYear(String.valueOf(DateUtil.year(dateTime)));
                teaPeasantYieldSales.setYieldValueMoney(new BigDecimal(0));
                result.add(teaPeasantYieldSales);
            }
        });
        return result;
    }
}
