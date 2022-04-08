package com.wanou.project.system.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.wanou.common.utils.SecurityUtils;
import com.wanou.project.system.domain.TeaEnterpriseInfo;
import com.wanou.project.system.service.ITeaEnterpriseInfoService;
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
    @Autowired
    private ITeaEnterpriseInfoService teaEnterpriseInfoService;

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
        if(teaEnterpriseYieldSales.getDeptId() == null){
            teaEnterpriseYieldSales.setDeptId(SecurityUtils.getDeptId());
        }
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

    @Override
    public List<Map<String,List>> selectTeaEnterpriseYieldSalesTotalRange(Long enterpriseId,int start, int end) {
        return teaEnterpriseYieldSalesMapper.selectTeaEnterpriseYieldSalesTotalRange(enterpriseId,start,end);
    }

    @Override
    public JSONObject getSalesYearOnYear(String region,Boolean isCountyEmp,Boolean isTownEmp) {
        //获取企业列表
        TeaEnterpriseInfo selectTeaEnterpriseInfo = new TeaEnterpriseInfo();
        selectTeaEnterpriseInfo.setIsCountyEmp(isCountyEmp);
        selectTeaEnterpriseInfo.setIsTownEmp(isTownEmp);
        selectTeaEnterpriseInfo.setRegion(region);
        List<TeaEnterpriseInfo> teaEnterpriseInfos = teaEnterpriseInfoService.selectTeaEnterpriseInfoList(selectTeaEnterpriseInfo);
        if(CollUtil.isEmpty(teaEnterpriseInfos)){
            return null;
        }
        //获取去年及前年
        DateTime nowDate = DateUtil.date();
        DateTime lastYear = DateUtil.offset(nowDate, DateField.YEAR, -1); //去年
        DateTime qianYear = DateUtil.offset(nowDate, DateField.YEAR, -2); //前年

        List<BigDecimal> salesNumYearOnYearArr = new ArrayList<>(teaEnterpriseInfos.size()); //销量同比
        List<BigDecimal> salesMoneyOnYearArr = new ArrayList<>(teaEnterpriseInfos.size()); //销售额同比
        List<String> categories = new ArrayList<>();
        teaEnterpriseInfos.forEach(teaEnterpriseInfo -> {
            //企业名
            categories.add(teaEnterpriseInfo.getEnterpriseName());

            //查询销量同比
            BigDecimal salesNumYearOnYear = teaEnterpriseYieldSalesMapper.getSalesNumYearOnYear(teaEnterpriseInfo.getId(),DateUtil.year(lastYear),DateUtil.year(qianYear));
            if(salesNumYearOnYear == null){
                salesNumYearOnYearArr.add(new BigDecimal(0));
            }else {
                salesNumYearOnYearArr.add(salesNumYearOnYear);
            }

            //查询销售额同比
            BigDecimal salesMoneyYearOnYear = teaEnterpriseYieldSalesMapper.getSalesMoneyYearOnYear(teaEnterpriseInfo.getId(),DateUtil.year(lastYear),DateUtil.year(qianYear));
            if(salesMoneyYearOnYear == null){
                salesMoneyOnYearArr.add(new BigDecimal(0));
            }else {
                salesMoneyOnYearArr.add(salesMoneyYearOnYear);
            }
        });
        JSONObject result = new JSONObject();
        result.put("categories",categories);
        result.put("salesNumYearOnYearArr",salesNumYearOnYearArr);
        result.put("salesMoneyOnYearArr",salesMoneyOnYearArr);
        return result;
    }

    @Override
    public List<JSONObject> getSalesByRegion(String region) {
        DateTime nowDate = DateUtil.date();
        DateTime startDate = DateUtil.offset(nowDate, DateField.YEAR, -5);
        DateTime endDate = DateUtil.offset(nowDate, DateField.YEAR, -1);
        return teaEnterpriseYieldSalesMapper.getSalesByRegion(region,DateUtil.year(startDate),DateUtil.year(endDate));
    }

    /**
     * 成本及利润统计
     * @param enterpriseId 茶企id
     * @return
     */
    @Override
    public List<JSONObject> costAndProfitStatistics(Long enterpriseId) {
        DateTime nowDate = DateUtil.date();
        DateTime startDate = DateUtil.offset(nowDate, DateField.YEAR, -5);
        DateTime endDate = DateUtil.offset(nowDate, DateField.YEAR, -1);
        return teaEnterpriseYieldSalesMapper.costAndProfitStatistics(enterpriseId,DateUtil.year(startDate),DateUtil.year(endDate));
    }

    /**
     * 按企业分组统计销量及销售额
     * @param region
     * @return
     */
    @Override
    public List<JSONObject> getYieldGroupEnterprise(String region) {
        DateTime nowDate = DateUtil.date();
        DateTime end = DateUtil.offset(nowDate, DateField.YEAR,-1);
        DateTime start = DateUtil.offset(nowDate, DateField.YEAR, -5);
        return teaEnterpriseYieldSalesMapper.getYieldGroupEnterprise(region,start,end);
    }
}
