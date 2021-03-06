package com.wanou.project.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 【请填写功能名称】对象 tea_garden
 *
 * @author ruoyi
 * @date 2022-03-03
 */
@Data
public class TeaGarden extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 茶园id */
    private Long teaGardenId;

    /** 茶园名称 */
    @Excel(name = "茶园名称")
    private String name;

    /** 茶园面积 */
    @Excel(name = "茶园面积")
    private Long teaArea;

    /** 茶树品种 */
    @Excel(name = "茶树品种")
    private Long teaTreeVariety;

    /** 从业人数 */
    @Excel(name = "从业人数")
    private Long employNum;

    /** 设施数量 */
    @Excel(name = "设施数量")
    private Long facilitiesNum;

    /** 年均产量 */
    @Excel(name = "年均产量")
    private BigDecimal averageYield;

    /** 预计总产量 */
    @Excel(name = "预计总产量")
    private BigDecimal totalProduction;

    /** 茶园类型 */
    @Excel(name = "茶园类型")
    private Long teaType;

    /** 负责人 */
    @Excel(name = "负责人")
    private String head;

    @Excel(name = "所属区域")
    private String region;

    private Long teaEnterpriseId; //关联茶企
}
