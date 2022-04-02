package com.wanou.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 种植大户收入对象 tea_peasant_income
 *
 * @author ruoyi
 * @date 2022-04-02
 */
public class TeaPeasantIncome extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 五万以下人的数量 */
    @Excel(name = "五万以下人的数量")
    private Long fiftyThousandLower;

    /** 五万以上人的数量 */
    @Excel(name = "五万以上人的数量")
    private Long fiftyThousandUpper;

    /** 十万以上人的数量 */
    @Excel(name = "十万以上人的数量")
    private Long tenThousandUpper;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setFiftyThousandLower(Long fiftyThousandLower)
    {
        this.fiftyThousandLower = fiftyThousandLower;
    }

    public Long getFiftyThousandLower()
    {
        return fiftyThousandLower;
    }
    public void setFiftyThousandUpper(Long fiftyThousandUpper)
    {
        this.fiftyThousandUpper = fiftyThousandUpper;
    }

    public Long getFiftyThousandUpper()
    {
        return fiftyThousandUpper;
    }
    public void setTenThousandUpper(Long tenThousandUpper)
    {
        this.tenThousandUpper = tenThousandUpper;
    }

    public Long getTenThousandUpper()
    {
        return tenThousandUpper;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fiftyThousandLower", getFiftyThousandLower())
            .append("fiftyThousandUpper", getFiftyThousandUpper())
            .append("tenThousandUpper", getTenThousandUpper())
            .toString();
    }
}
