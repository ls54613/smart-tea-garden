package com.wanou.project.system.domain;

import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶仓基本情况对象 tea_warehouse_essential
 *
 * @author ruoyi
 * @date 2022-03-07
 */
@Data
public class TeaWarehouseEssential extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 茶仓基本情况表id */
    private Long id;

    /** 关联企业单位id */
    @Excel(name = "关联企业单位id")
    private Long enterpriseId;

    /** 茶仓面积 */
    @Excel(name = "茶仓面积")
    private BigDecimal measure;

    /** 茶仓容量 */
    @Excel(name = "茶仓容量")
    private BigDecimal capacity;

    /** 设施数量 */
    @Excel(name = "设施数量")
    private Long facilitiesNumber;

    /** 利用率 */
    @Excel(name = "利用率")
    private String utilization;

    /** 负责人 */
    @Excel(name = "负责人")
    private String personCharge;

    /** 现存量 */
    @Excel(name = "现存量")
    private BigDecimal quantity;

    /** 出库总量 */
    @Excel(name = "出库总量")
    private BigDecimal outboundVolume;

    @Excel(name = "仓库类型1=干仓2=湿仓")
    private Long warehouseType;//茶仓类型




}
