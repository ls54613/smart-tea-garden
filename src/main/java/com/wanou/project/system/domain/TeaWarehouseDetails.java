package com.wanou.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶仓详情对象 tea_warehouse_details
 *
 * @author ruoyi
 * @date 2022-03-07
 */
public class TeaWarehouseDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 茶仓基本详情id */
    private Long id;

    /** 占地面积 */
    @Excel(name = "占地面积")
    private BigDecimal areaCovered;

    /** 库存总量 */
    @Excel(name = "库存总量")
    private BigDecimal totalInventory;

    /** 出库总量 */
    @Excel(name = "出库总量")
    private BigDecimal totalOutbound;

    /** 关联茶仓基本信息id */
    @Excel(name = "关联茶仓基本信息id")
    private Long teaWarehouseId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAreaCovered(BigDecimal areaCovered)
    {
        this.areaCovered = areaCovered;
    }

    public BigDecimal getAreaCovered()
    {
        return areaCovered;
    }
    public void setTotalInventory(BigDecimal totalInventory)
    {
        this.totalInventory = totalInventory;
    }

    public BigDecimal getTotalInventory()
    {
        return totalInventory;
    }
    public void setTotalOutbound(BigDecimal totalOutbound)
    {
        this.totalOutbound = totalOutbound;
    }

    public BigDecimal getTotalOutbound()
    {
        return totalOutbound;
    }
    public void setTeaWarehouseId(Long teaWarehouseId)
    {
        this.teaWarehouseId = teaWarehouseId;
    }

    public Long getTeaWarehouseId()
    {
        return teaWarehouseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaCovered", getAreaCovered())
            .append("totalInventory", getTotalInventory())
            .append("totalOutbound", getTotalOutbound())
            .append("teaWarehouseId", getTeaWarehouseId())
            .toString();
    }
}
