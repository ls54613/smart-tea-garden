package com.wanou.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 近半年采购情况对象 tea_enterprise_procurement
 *
 * @author MrYao
 * @date 2022-03-03
 */
public class TeaEnterpriseProcurement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购情况id */
    private Long id;

    /** 采购日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采购日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseDate;

    /** 采购物品 */
    @Excel(name = "采购物品")
    private String purchaseGoods;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long purchaseNumber;

    /** 关联茶企id */
    @Excel(name = "关联茶企id")
    private Long teaEnterpriseId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPurchaseDate(Date purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate()
    {
        return purchaseDate;
    }
    public void setPurchaseGoods(String purchaseGoods)
    {
        this.purchaseGoods = purchaseGoods;
    }

    public String getPurchaseGoods()
    {
        return purchaseGoods;
    }
    public void setPurchaseNumber(Long purchaseNumber)
    {
        this.purchaseNumber = purchaseNumber;
    }

    public Long getPurchaseNumber()
    {
        return purchaseNumber;
    }
    public void setTeaEnterpriseId(Long teaEnterpriseId)
    {
        this.teaEnterpriseId = teaEnterpriseId;
    }

    public Long getTeaEnterpriseId()
    {
        return teaEnterpriseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchaseDate", getPurchaseDate())
            .append("purchaseGoods", getPurchaseGoods())
            .append("purchaseNumber", getPurchaseNumber())
            .append("teaEnterpriseId", getTeaEnterpriseId())
            .toString();
    }
}
