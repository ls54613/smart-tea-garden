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

    private Integer deptId;

}
