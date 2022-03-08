package com.wanou.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶农历年年收入对象 tea_peasant_annual
 *
 * @author MrYao
 * @date 2022-03-04
 */
public class TeaPeasantAnnual extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 年收入id */
    private Long id;

    /** 预计收入 */
    @Excel(name = "预计收入")
    private String estimatedIncome;

    /** 收入类型 */
    @Excel(name = "收入类型")
    private String incomeType;

    /** 是否增收0=是1=否2=未知 */
    @Excel(name = "是否增收0=是1=否2=未知")
    private Long whetherIncrease;

    /**年份*/
    @Excel(name = "年份")
    private String year;

    /** 关联茶农id */
    @Excel(name = "关联茶农id")
    private Long teaPeasantId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEstimatedIncome(String estimatedIncome)
    {
        this.estimatedIncome = estimatedIncome;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getYear()
    {
        return year;
    }

    public String getEstimatedIncome()
    {
        return estimatedIncome;
    }
    public void setIncomeType(String incomeType)
    {
        this.incomeType = incomeType;
    }

    public String getIncomeType()
    {
        return incomeType;
    }
    public void setWhetherIncrease(Long whetherIncrease)
    {
        this.whetherIncrease = whetherIncrease;
    }

    public Long getWhetherIncrease()
    {
        return whetherIncrease;
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
            .append("estimatedIncome", getEstimatedIncome())
            .append("incomeType", getIncomeType())
            .append("whetherIncrease", getWhetherIncrease())
            .append("teaPeasantId", getTeaPeasantId())
            .toString();
    }
}
