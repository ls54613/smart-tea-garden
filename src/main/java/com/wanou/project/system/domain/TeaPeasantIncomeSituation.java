package com.wanou.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 人均收入情况对象 tea_peasant_income_situation
 *
 * @author ruoyi
 * @date 2022-04-02
 */
public class TeaPeasantIncomeSituation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 年份 */
    @Excel(name = "年份")
    private String year;

    /** 茶农人均（万元） */
    @Excel(name = "茶农人均", readConverterExp = "万=元")
    private BigDecimal teaFarmersPer;

    /** 总体人均（万元） */
    @Excel(name = "总体人均", readConverterExp = "万=元")
    private BigDecimal totalPerCapita;

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
    public void setTeaFarmersPer(BigDecimal teaFarmersPer)
    {
        this.teaFarmersPer = teaFarmersPer;
    }

    public BigDecimal getTeaFarmersPer()
    {
        return teaFarmersPer;
    }
    public void setTotalPerCapita(BigDecimal totalPerCapita)
    {
        this.totalPerCapita = totalPerCapita;
    }

    public BigDecimal getTotalPerCapita()
    {
        return totalPerCapita;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("year", getYear())
            .append("teaFarmersPer", getTeaFarmersPer())
            .append("totalPerCapita", getTotalPerCapita())
            .toString();
    }
}
