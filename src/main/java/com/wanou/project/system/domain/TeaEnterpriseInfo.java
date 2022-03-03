package com.wanou.project.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶企基本信息对象 tea_enterprise_info
 *
 * @author MrYao
 * @date 2022-03-01
 */

public class TeaEnterpriseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String enterpriseName;

    /** 主体类型 */
    @Excel(name = "主体类型")
    private String type;

    /** 企业性质 */
    @Excel(name = "企业性质")
    private String nature;

    /** 成立时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date setUpDate;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String legalPerson;

    /** 法人身份证 */
    @Excel(name = "法人身份证")
    private String legalPersonIdCard;

    /** 企业经营状态:
1=存续
2=在业
3=吊销
4=注销
5=迁入
6=迁出
7=停业
8=清算 */
    @Excel(name = "企业经营状态: 1=存续 2=在业 3=吊销 4=注销 5=迁入 6=迁出 7=停业 8=清算")
    private Long operationStatus;

    /** 注册资本 */
    @Excel(name = "注册资本")
    private String regCapital;

    /** 企业地址 */
    @Excel(name = "企业地址")
    private String address;

    /** 企业简介 */
    @Excel(name = "企业简介")
    private String about;

    /** 种植面积(亩) */
    @Excel(name = "种植面积(亩)")
    private BigDecimal cultivatedArea;

    /** 从业人员数量 */
    @Excel(name = "从业人员数量")
    private Long workPersonNum;

    /** 年销量 */
    @Excel(name = "年销量")
    private BigDecimal yearSales;

    /** 年产量 */
    @Excel(name = "年产量")
    private BigDecimal yearOutput;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEnterpriseName(String enterpriseName)
    {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseName()
    {
        return enterpriseName;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setNature(String nature)
    {
        this.nature = nature;
    }

    public String getNature()
    {
        return nature;
    }
    public void setSetUpDate(Date setUpDate)
    {
        this.setUpDate = setUpDate;
    }

    public Date getSetUpDate()
    {
        return setUpDate;
    }
    public void setLegalPerson(String legalPerson)
    {
        this.legalPerson = legalPerson;
    }

    public String getLegalPerson()
    {
        return legalPerson;
    }
    public void setLegalPersonIdCard(String legalPersonIdCard)
    {
        this.legalPersonIdCard = legalPersonIdCard;
    }

    public String getLegalPersonIdCard()
    {
        return legalPersonIdCard;
    }
    public void setOperationStatus(Long operationStatus)
    {
        this.operationStatus = operationStatus;
    }

    public Long getOperationStatus()
    {
        return operationStatus;
    }
    public void setRegCapital(String regCapital)
    {
        this.regCapital = regCapital;
    }

    public String getRegCapital()
    {
        return regCapital;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setAbout(String about)
    {
        this.about = about;
    }

    public String getAbout()
    {
        return about;
    }
    public void setCultivatedArea(BigDecimal cultivatedArea)
    {
        this.cultivatedArea = cultivatedArea;
    }

    public BigDecimal getCultivatedArea()
    {
        return cultivatedArea;
    }
    public void setWorkPersonNum(Long workPersonNum)
    {
        this.workPersonNum = workPersonNum;
    }

    public Long getWorkPersonNum()
    {
        return workPersonNum;
    }
    public void setYearSales(BigDecimal yearSales)
    {
        this.yearSales = yearSales;
    }

    public BigDecimal getYearSales()
    {
        return yearSales;
    }
    public void setYearOutput(BigDecimal yearOutput)
    {
        this.yearOutput = yearOutput;
    }

    public BigDecimal getYearOutput()
    {
        return yearOutput;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("enterpriseName", getEnterpriseName())
            .append("type", getType())
            .append("nature", getNature())
            .append("setUpDate", getSetUpDate())
            .append("legalPerson", getLegalPerson())
            .append("legalPersonIdCard", getLegalPersonIdCard())
            .append("operationStatus", getOperationStatus())
            .append("regCapital", getRegCapital())
            .append("address", getAddress())
            .append("about", getAbout())
            .append("cultivatedArea", getCultivatedArea())
            .append("workPersonNum", getWorkPersonNum())
            .append("yearSales", getYearSales())
            .append("yearOutput", getYearOutput())
            .toString();
    }
}
