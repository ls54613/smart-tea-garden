package com.wanou.project.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
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
@Data
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

//    /** 企业简介 */
//    @Excel(name = "企业简介")
//    private String about;

    /** 种植面积(亩) */
    @Excel(name = "种植面积(亩)")
    private BigDecimal cultivatedArea;

    /** 从业人员数量 */
    @Excel(name = "从业人员数量")
    private Long workPersonNum;
//
//    /** 年销量 */
//    @Excel(name = "年销量")
//    private BigDecimal yearSales;
//
//    /** 年产量 */
//    @Excel(name = "年产量")
//    private BigDecimal yearOutput;
    @Excel(name = "茶叶品种")
    private List<Integer> teaType;

    @Excel(name = "茶企所属区域")
    private String region; //茶企所属区域

    private Boolean isCountyEmp; //是否县重点企业

    private Boolean isTownEmp; //是否乡镇重点企业

    private Long deptId; //所属部门id



    @Override
    public String toString() {
        return "TeaEnterpriseInfo{" +
                "id=" + id +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", type='" + type + '\'' +
                ", nature='" + nature + '\'' +
                ", setUpDate=" + setUpDate +
                ", legalPerson='" + legalPerson + '\'' +
                ", legalPersonIdCard='" + legalPersonIdCard + '\'' +
                ", operationStatus=" + operationStatus +
                ", regCapital='" + regCapital + '\'' +
                ", address='" + address + '\'' +
                ", cultivatedArea=" + cultivatedArea +
                ", workPersonNum=" + workPersonNum +
                ", teaType=" + teaType +
                ", region='" + region + '\'' +
                ", isCountyEmp=" + isCountyEmp +
                ", isTownEmp=" + isTownEmp +
                ", deptId=" + deptId +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Date getSetUpDate() {
        return setUpDate;
    }

    public void setSetUpDate(Date setUpDate) {
        this.setUpDate = setUpDate;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalPersonIdCard() {
        return legalPersonIdCard;
    }

    public void setLegalPersonIdCard(String legalPersonIdCard) {
        this.legalPersonIdCard = legalPersonIdCard;
    }

    public Long getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(Long operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getCultivatedArea() {
        return cultivatedArea;
    }

    public void setCultivatedArea(BigDecimal cultivatedArea) {
        this.cultivatedArea = cultivatedArea;
    }

    public Long getWorkPersonNum() {
        return workPersonNum;
    }

    public void setWorkPersonNum(Long workPersonNum) {
        this.workPersonNum = workPersonNum;
    }

    public List<Integer> getTeaType() {
        return teaType;
    }

    public void setTeaType(List<Integer> teaType) {
        this.teaType = teaType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Boolean getCountyEmp() {
        return isCountyEmp;
    }

    public void setCountyEmp(Boolean countyEmp) {
        isCountyEmp = countyEmp;
    }

    public Boolean getTownEmp() {
        return isTownEmp;
    }

    public void setTownEmp(Boolean townEmp) {
        isTownEmp = townEmp;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}

