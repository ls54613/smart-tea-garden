package com.wanou.project.system.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.wanou.project.system.domain.TeaEnterpriseYieldSales;

/**
 * 企业历年产量及销售情况Service接口
 *
 * @author ruoyi
 * @date 2022-03-07
 */
public interface ITeaEnterpriseYieldSalesService
{
    /**
     * 查询企业历年产量及销售情况
     *
     * @param id 企业历年产量及销售情况主键
     * @return 企业历年产量及销售情况
     */
    public TeaEnterpriseYieldSales selectTeaEnterpriseYieldSalesById(Long id);

    /**
     * 查询企业历年产量及销售情况列表
     *
     * @param teaEnterpriseYieldSales 企业历年产量及销售情况
     * @return 企业历年产量及销售情况集合
     */
    public List<TeaEnterpriseYieldSales> selectTeaEnterpriseYieldSalesList(TeaEnterpriseYieldSales teaEnterpriseYieldSales);

    /**
     * 新增企业历年产量及销售情况
     *
     * @param teaEnterpriseYieldSales 企业历年产量及销售情况
     * @return 结果
     */
    public int insertTeaEnterpriseYieldSales(TeaEnterpriseYieldSales teaEnterpriseYieldSales);

    /**
     * 修改企业历年产量及销售情况
     *
     * @param teaEnterpriseYieldSales 企业历年产量及销售情况
     * @return 结果
     */
    public int updateTeaEnterpriseYieldSales(TeaEnterpriseYieldSales teaEnterpriseYieldSales);

    /**
     * 批量删除企业历年产量及销售情况
     *
     * @param ids 需要删除的企业历年产量及销售情况主键集合
     * @return 结果
     */
    public int deleteTeaEnterpriseYieldSalesByIds(Long[] ids);

    /**
     * 删除企业历年产量及销售情况信息
     *
     * @param id 企业历年产量及销售情况主键
     * @return 结果
     */
    public int deleteTeaEnterpriseYieldSalesById(Long id);

    List<Map<String,List>> selectTeaEnterpriseYieldSalesTotalRange(int start, int end);

    JSONObject getSalesYearOnYear();
}
