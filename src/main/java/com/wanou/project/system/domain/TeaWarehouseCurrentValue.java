package com.wanou.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 当前库存情况货值分布对象 tea_warehouse_current_value
 *
 * @author ruoyi
 * @date 2022-03-07
 */
public class TeaWarehouseCurrentValue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 当前库存情况货值分布id */
    private Long id;

    /** 品种1=碧香早2=安吉白茶3=黄金茶4=楮叶齐 */
    @Excel(name = "品种1=碧香早2=安吉白茶3=黄金茶4=楮叶齐")
    private Long varieties;

    /** 当前库存量(吨) */
    @Excel(name = "当前库存量(吨)")
    private BigDecimal currentInventory;

    /** 货值(万元) */
    @Excel(name = "货值(万元)")
    private BigDecimal goodsValue;

    /** 库存预警量 */
    @Excel(name = "库存预警量")
    private BigDecimal inventoryWarningQuantity;

    /** 与茶仓基本信息进行关联 */
    @Excel(name = "与茶仓基本信息进行关联")
    private Long teaWarehouseId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setVarieties(Long varieties)
    {
        this.varieties = varieties;
    }

    public Long getVarieties()
    {
        return varieties;
    }
    public void setCurrentInventory(BigDecimal currentInventory)
    {
        this.currentInventory = currentInventory;
    }

    public BigDecimal getCurrentInventory()
    {
        return currentInventory;
    }
    public void setGoodsValue(BigDecimal goodsValue)
    {
        this.goodsValue = goodsValue;
    }

    public BigDecimal getGoodsValue()
    {
        return goodsValue;
    }
    public void setInventoryWarningQuantity(BigDecimal inventoryWarningQuantity)
    {
        this.inventoryWarningQuantity = inventoryWarningQuantity;
    }

    public BigDecimal getInventoryWarningQuantity()
    {
        return inventoryWarningQuantity;
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
            .append("varieties", getVarieties())
            .append("currentInventory", getCurrentInventory())
            .append("goodsValue", getGoodsValue())
            .append("inventoryWarningQuantity", getInventoryWarningQuantity())
            .append("teaWarehouseId", getTeaWarehouseId())
            .toString();
    }
}
