package com.wanou.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 中国茶叶线上销售品类数据监测对象 tea_market_preference_rate
 *
 * @author ruoyi
 * @date 2022-04-06
 */
public class TeaMarketPreferenceRate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 茶品种类 */
    @Excel(name = "茶品种类")
    private String teaType;

    /** 偏好率 */
    @Excel(name = "偏好率")
    private BigDecimal preferenceRate;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTeaType(String teaType)
    {
        this.teaType = teaType;
    }

    public String getTeaType()
    {
        return teaType;
    }
    public void setPreferenceRate(BigDecimal preferenceRate)
    {
        this.preferenceRate = preferenceRate;
    }

    public BigDecimal getPreferenceRate()
    {
        return preferenceRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teaType", getTeaType())
            .append("preferenceRate", getPreferenceRate())
            .toString();
    }
}
