package com.wanou.project.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 茶农历年年收入对象 tea_peasant_annual
 *
 * @author MrYao
 * @date 2022-03-04
 */
@Data
public class TeaPeasantAnnual extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 年收入id */
    private Long id;

    /** 预计收入 */
    @Excel(name = "预计收入")
    private BigDecimal estimatedIncome;

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


}
