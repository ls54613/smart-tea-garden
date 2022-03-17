package com.wanou.project.system.domain;

import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶园土壤监测对象 tea_garden_soil_monitor
 *
 * @author txh
 * @date 2022-03-17
 */
@Data
public class TeaGardenSoilMonitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 关联茶园 */
    @Excel(name = "关联茶园")
    private Long teaGardenId;

    /** 指标 */
    @Excel(name = "指标")
    private String key;

    /** 指标值 */
    @Excel(name = "指标值")
    private BigDecimal value;
}
