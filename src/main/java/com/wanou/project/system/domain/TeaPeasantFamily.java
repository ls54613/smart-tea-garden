package com.wanou.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶农家庭成员对象 tea_peasant_family
 *
 * @author MrYao
 * @date 2022-03-03
 */
public class TeaPeasantFamily extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 家庭成员ID */
    private Long id;

    /** 成员姓名 */
    @Excel(name = "成员姓名")
    private String familyName;

    /** 性别0=男 1=女 2=未知 */
    @Excel(name = "性别0=男 1=女 2=未知")
    private Long familySex;

    /** 关系 */
    @Excel(name = "关系")
    private String relationship;

    /** 证件类型1=身份证  */
    @Excel(name = "证件类型1=身份证 ")
    private Long cardType;

    /** 证件号 */
    @Excel(name = "证件号")
    private String idCard;

    /** 关联茶农id */
    @Excel(name = "关联茶农id")
    private Long teaPeasantId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public String getFamilyName()
    {
        return familyName;
    }
    public void setFamilySex(Long familySex)
    {
        this.familySex = familySex;
    }

    public Long getFamilySex()
    {
        return familySex;
    }
    public void setRelationship(String relationship)
    {
        this.relationship = relationship;
    }

    public String getRelationship()
    {
        return relationship;
    }
    public void setCardType(Long cardType)
    {
        this.cardType = cardType;
    }

    public Long getCardType()
    {
        return cardType;
    }
    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getIdCard()
    {
        return idCard;
    }
    public void setTeaPeasantId(Long teaPeasantId)
    {
        this.teaPeasantId = teaPeasantId;
    }

    public Long getTeaPeasantId()
    {
        return teaPeasantId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("familyName", getFamilyName())
            .append("familySex", getFamilySex())
            .append("relationship", getRelationship())
            .append("cardType", getCardType())
            .append("idCard", getIdCard())
            .append("teaPeasantId", getTeaPeasantId())
            .toString();
    }
}
