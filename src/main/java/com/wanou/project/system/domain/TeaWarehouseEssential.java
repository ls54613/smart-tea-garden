package com.wanou.project.system.domain;

import java.math.BigDecimal;
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

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEnterpriseId(Long enterpriseId)
    {
        this.enterpriseId = enterpriseId;
    }

    public Long getEnterpriseId()
    {
        return enterpriseId;
    }
    public void setMeasure(BigDecimal measure)
    {
        this.measure = measure;
    }

    public BigDecimal getMeasure()
    {
        return measure;
    }
    public void setCapacity(BigDecimal capacity)
    {
        this.capacity = capacity;
    }

    public BigDecimal getCapacity()
    {
        return capacity;
    }
    public void setFacilitiesNumber(Long facilitiesNumber)
    {
        this.facilitiesNumber = facilitiesNumber;
    }

    public Long getFacilitiesNumber()
    {
        return facilitiesNumber;
    }
    public void setUtilization(String utilization)
    {
        this.utilization = utilization;
    }

    public String getUtilization()
    {
        return utilization;
    }
    public void setPersonCharge(String personCharge)
    {
        this.personCharge = personCharge;
    }

    public String getPersonCharge()
    {
        return personCharge;
    }
    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity()
    {
        return quantity;
    }
    public void setOutboundVolume(BigDecimal outboundVolume)
    {
        this.outboundVolume = outboundVolume;
    }

    public BigDecimal getOutboundVolume()
    {
        return outboundVolume;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("enterpriseId", getEnterpriseId())
            .append("measure", getMeasure())
            .append("capacity", getCapacity())
            .append("facilitiesNumber", getFacilitiesNumber())
            .append("utilization", getUtilization())
            .append("personCharge", getPersonCharge())
            .append("quantity", getQuantity())
            .append("outboundVolume", getOutboundVolume())
            .toString();
    }
}
