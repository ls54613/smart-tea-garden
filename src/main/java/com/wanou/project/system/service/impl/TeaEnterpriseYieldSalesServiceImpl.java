package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaEnterpriseYieldSalesMapper;
import com.wanou.project.system.domain.TeaEnterpriseYieldSales;
import com.wanou.project.system.service.ITeaEnterpriseYieldSalesService;

/**
 * 企业历年产量及销售情况Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-07
 */
@Service
public class TeaEnterpriseYieldSalesServiceImpl implements ITeaEnterpriseYieldSalesService
{
    @Autowired
    private TeaEnterpriseYieldSalesMapper teaEnterpriseYieldSalesMapper;

    /**
     * 查询企业历年产量及销售情况
     *
     * @param id 企业历年产量及销售情况主键
     * @return 企业历年产量及销售情况
     */
    @Override
    public TeaEnterpriseYieldSales selectTeaEnterpriseYieldSalesById(Long id)
    {
        return teaEnterpriseYieldSalesMapper.selectTeaEnterpriseYieldSalesById(id);
    }

    /**
     * 查询企业历年产量及销售情况列表
     *
     * @param teaEnterpriseYieldSales 企业历年产量及销售情况
     * @return 企业历年产量及销售情况
     */
    @Override
    public List<TeaEnterpriseYieldSales> selectTeaEnterpriseYieldSalesList(TeaEnterpriseYieldSales teaEnterpriseYieldSales)
    {
        return teaEnterpriseYieldSalesMapper.selectTeaEnterpriseYieldSalesList(teaEnterpriseYieldSales);
    }

    /**
     * 新增企业历年产量及销售情况
     *
     * @param teaEnterpriseYieldSales 企业历年产量及销售情况
     * @return 结果
     */
    @Override
    public int insertTeaEnterpriseYieldSales(TeaEnterpriseYieldSales teaEnterpriseYieldSales)
    {
        return teaEnterpriseYieldSalesMapper.insertTeaEnterpriseYieldSales(teaEnterpriseYieldSales);
    }

    /**
     * 修改企业历年产量及销售情况
     *
     * @param teaEnterpriseYieldSales 企业历年产量及销售情况
     * @return 结果
     */
    @Override
    public int updateTeaEnterpriseYieldSales(TeaEnterpriseYieldSales teaEnterpriseYieldSales)
    {
        return teaEnterpriseYieldSalesMapper.updateTeaEnterpriseYieldSales(teaEnterpriseYieldSales);
    }

    /**
     * 批量删除企业历年产量及销售情况
     *
     * @param ids 需要删除的企业历年产量及销售情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaEnterpriseYieldSalesByIds(Long[] ids)
    {
        return teaEnterpriseYieldSalesMapper.deleteTeaEnterpriseYieldSalesByIds(ids);
    }

    /**
     * 删除企业历年产量及销售情况信息
     *
     * @param id 企业历年产量及销售情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaEnterpriseYieldSalesById(Long id)
    {
        return teaEnterpriseYieldSalesMapper.deleteTeaEnterpriseYieldSalesById(id);
    }
}