package com.wanou.project.system.domain;

import java.math.BigDecimal;

import lombok.Data;
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
@Data
public class TeaEnterpriseYieldSales extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 历年产量及销售情况id */
    private Long id;

    /** 年度 */
    @Excel(name = "年度")
    private Integer year;

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
}
