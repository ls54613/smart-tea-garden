package com.wanou.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 2021年各品种产量占比情况对象 tea_market_proportion
 *
 * @author ruoyi
 * @date 2022-04-02
 */
public class TeaMarketProportion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 茶市id */
    private Long id;

    /** 茶叶品种 */
    @Excel(name = "茶叶品种")
    private Long teaType;

    /** 占比情况 */
    @Excel(name = "占比情况")
    private BigDecimal proportion;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTeaType(Long teaType)
    {
        this.teaType = teaType;
    }

    public Long getTeaType()
    {
        return teaType;
    }
    public void setProportion(BigDecimal proportion)
    {
        this.proportion = proportion;
    }

    public BigDecimal getProportion()
    {
        return proportion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teaType", getTeaType())
            .append("proportion", getProportion())
            .toString();
    }
}
