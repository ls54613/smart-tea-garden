package com.wanou.project.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

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

    /** 企业单位 */
    @Excel(name = "企业单位")
    private String enterprises;

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
    private Long averageYield;

    /** 预计总产量 */
    @Excel(name = "预计总产量")
    private String totalProduction;

    /** 茶园类型 */
    @Excel(name = "茶园类型")
    private Long teaType;

    /** 负责人 */
    @Excel(name = "负责人")
    private String head;

    @Excel(name = "所属区域")
    private String region;

    @Excel(name = "茶企id")
    private Long TeaEnterpriseId;
}
