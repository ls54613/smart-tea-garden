package com.wanou.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶市基本情况表对象 tea_market_year
 *
 * @author ruoyi
 * @date 2022-04-02
 */
public class TeaMarketYear extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 茶市id */
    private Long id;

    /** 年份
年份 */
    @Excel(name = "年份")
    private String year;

    /** 中国茶叶内销总量（万吨） */
    @Excel(name = "中国茶叶内销总量", readConverterExp = "万=吨")
    private BigDecimal teaTotalSales;

    /** 中国茶叶线上占比（%） */
    @Excel(name = "中国茶叶线上占比", readConverterExp = "%=")
    private BigDecimal teaOnlineProportion;

    /** 中国茶叶线下占比（%） */
    @Excel(name = "中国茶叶线下占比", readConverterExp = "%=")
    private BigDecimal teaOfflineProportion;

    /** 中国茶叶人均消费量（千克） */
    @Excel(name = "中国茶叶人均消费量", readConverterExp = "千=克")
    private BigDecimal teaCapitaConsumption;

    /** 中国常宁茶叶内销总量（万吨） */
    @Excel(name = "中国常宁茶叶内销总量", readConverterExp = "万=吨")
    private BigDecimal teaChangningTotalSales;

    /** 中国常宁茶叶产量（吨） */
    @Excel(name = "中国常宁茶叶产量", readConverterExp = "吨=")
    private BigDecimal teaChangningYield;

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
    public void setTeaTotalSales(BigDecimal teaTotalSales)
    {
        this.teaTotalSales = teaTotalSales;
    }

    public BigDecimal getTeaTotalSales()
    {
        return teaTotalSales;
    }
    public void setTeaOnlineProportion(BigDecimal teaOnlineProportion)
    {
        this.teaOnlineProportion = teaOnlineProportion;
    }

    public BigDecimal getTeaOnlineProportion()
    {
        return teaOnlineProportion;
    }
    public void setTeaOfflineProportion(BigDecimal teaOfflineProportion)
    {
        this.teaOfflineProportion = teaOfflineProportion;
    }

    public BigDecimal getTeaOfflineProportion()
    {
        return teaOfflineProportion;
    }
    public void setTeaCapitaConsumption(BigDecimal teaCapitaConsumption)
    {
        this.teaCapitaConsumption = teaCapitaConsumption;
    }

    public BigDecimal getTeaCapitaConsumption()
    {
        return teaCapitaConsumption;
    }
    public void setTeaChangningTotalSales(BigDecimal teaChangningTotalSales)
    {
        this.teaChangningTotalSales = teaChangningTotalSales;
    }

    public BigDecimal getTeaChangningTotalSales()
    {
        return teaChangningTotalSales;
    }
    public void setTeaChangningYield(BigDecimal teaChangningYield)
    {
        this.teaChangningYield = teaChangningYield;
    }

    public BigDecimal getTeaChangningYield()
    {
        return teaChangningYield;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("year", getYear())
            .append("teaTotalSales", getTeaTotalSales())
            .append("teaOnlineProportion", getTeaOnlineProportion())
            .append("teaOfflineProportion", getTeaOfflineProportion())
            .append("teaCapitaConsumption", getTeaCapitaConsumption())
            .append("teaChangningTotalSales", getTeaChangningTotalSales())
            .append("teaChangningYield", getTeaChangningYield())
            .toString();
    }
}
