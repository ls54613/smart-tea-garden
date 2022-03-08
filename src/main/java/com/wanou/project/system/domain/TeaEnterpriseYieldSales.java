package com.wanou.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 企业历年产量及销售情况对象 tea_enterprise_yield_sales
 *
 * @author ruoyi
 * @date 2022-03-07
 */
public class TeaEnterpriseYieldSales extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 历年产量及销售情况id */
    private Long id;

    /** 年度 */
    @Excel(name = "年度")
    private String year;

    /** 产量及产值数量 */
    @Excel(name = "产量及产值数量")
    private BigDecimal yieldValueNumber;

    /** 产量及产值金额 */
    @Excel(name = "产量及产值金额")
    private BigDecimal yieldValueMoney;

    /** 销量及销售额数量 */
    @Excel(name = "销量及销售额数量")
    private BigDecimal salesVolumeNumber;

    /** 销量及销售额金额 */
    @Excel(name = "销量及销售额金额")
    private BigDecimal salesVolumeMoney;

    /** 产品利润统计 */
    @Excel(name = "产品利润统计")
    private BigDecimal productProfitStatistics;

    /** 产品成本统计 */
    @Excel(name = "产品成本统计")
    private BigDecimal productCostStatistics;

    /** 茶企关联id */
    @Excel(name = "茶企关联id")
    private Long teaPeasantId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setYear(String year)
    {
        this.year = year;
    }

    public String getYear()
    {
        return year;
    }
    public void setYieldValueNumber(BigDecimal yieldValueNumber)
    {
        this.yieldValueNumber = yieldValueNumber;
    }

    public BigDecimal getYieldValueNumber()
    {
        return yieldValueNumber;
    }
    public void setYieldValueMoney(BigDecimal yieldValueMoney)
    {
        this.yieldValueMoney = yieldValueMoney;
    }

    public BigDecimal getYieldValueMoney()
    {
        return yieldValueMoney;
    }
    public void setSalesVolumeNumber(BigDecimal salesVolumeNumber)
    {
        this.salesVolumeNumber = salesVolumeNumber;
    }

    public BigDecimal getSalesVolumeNumber()
    {
        return salesVolumeNumber;
    }
    public void setSalesVolumeMoney(BigDecimal salesVolumeMoney)
    {
        this.salesVolumeMoney = salesVolumeMoney;
    }

    public BigDecimal getSalesVolumeMoney()
    {
        return salesVolumeMoney;
    }
    public void setProductProfitStatistics(BigDecimal productProfitStatistics)
    {
        this.productProfitStatistics = productProfitStatistics;
    }

    public BigDecimal getProductProfitStatistics()
    {
        return productProfitStatistics;
    }
    public void setProductCostStatistics(BigDecimal productCostStatistics)
    {
        this.productCostStatistics = productCostStatistics;
    }

    public BigDecimal getProductCostStatistics()
    {
        return productCostStatistics;
    }
    public void setTeaPeasantId(Long teaPeasantId)
    {
        this.teaPeasantId = teaPeasantId;
    }

    public Long getTeaPeasantId()
    {
        return teaPeasantId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("year", getYear())
            .append("yieldValueNumber", getYieldValueNumber())
            .append("yieldValueMoney", getYieldValueMoney())
            .append("salesVolumeNumber", getSalesVolumeNumber())
            .append("salesVolumeMoney", getSalesVolumeMoney())
            .append("productProfitStatistics", getProductProfitStatistics())
            .append("productCostStatistics", getProductCostStatistics())
            .append("teaPeasantId", getTeaPeasantId())
            .toString();
    }
}
