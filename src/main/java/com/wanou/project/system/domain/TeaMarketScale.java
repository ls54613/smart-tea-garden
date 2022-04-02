package com.wanou.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 2021年各品种产量占比情况对象 tea_market_scale
 *
 * @author MrYao
 * @date 2022-04-02
 */
public class TeaMarketScale extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 线上市场规模 */
    @Excel(name = "线上市场规模")
    private BigDecimal teaMarketSize;

    /** 增长率 */
    @Excel(name = "增长率")
    private BigDecimal teaGrowthRate;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTeaMarketSize(BigDecimal teaMarketSize)
    {
        this.teaMarketSize = teaMarketSize;
    }

    public BigDecimal getTeaMarketSize()
    {
        return teaMarketSize;
    }
    public void setTeaGrowthRate(BigDecimal teaGrowthRate)
    {
        this.teaGrowthRate = teaGrowthRate;
    }

    public BigDecimal getTeaGrowthRate()
    {
        return teaGrowthRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teaMarketSize", getTeaMarketSize())
            .append("teaGrowthRate", getTeaGrowthRate())
            .toString();
    }
}
