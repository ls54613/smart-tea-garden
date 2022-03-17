package com.wanou.project.system.domain;

import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 病虫害分析对象 tea_garden_disease
 *
 * @author txh
 * @date 2022-03-17
 */
@Data
public class TeaGardenDisease extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 病虫害类型 */
    @Excel(name = "病虫害类型")
    private Long type;

    /** 病虫害分析值 */
    @Excel(name = "病虫害分析值")
    private BigDecimal value;

    /** 关联茶园 */
    @Excel(name = "关联茶园")
    private Long teaGardenId;
}
