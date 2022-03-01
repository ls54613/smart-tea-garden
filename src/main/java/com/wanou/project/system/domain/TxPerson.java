package com.wanou.project.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 人员管理对象 tx_person
 *
 * @author wanou
 * @date 2021-08-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TxPerson extends BaseEntity
{


    private static final long serialVersionUID = 7062099713198022529L;
    /** 人员ID */
    private Long staffid;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idcardNum;

    /** 手机号 */
    @Excel(name = "手机号")
    private String mobile;

    /** 人像 */
    @Excel(name = "人像")
    private String imgBase64;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** Ic卡号 */
    @Excel(name = "Ic卡号")
    private String icno;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private Long departmentId;

    /** 通行区域 */
    @Excel(name = "通行区域")
    private String domainId;

    /** 人员类型 */
    @Excel(name = "人员类型")
    @JsonProperty("pType")
    private Integer pType;

    /** 人员性别 */
    @Excel(name = "人员性别")
    private Integer sex;

    /** 证件照 */
    @Excel(name = "证件照")
    private String licenseImage;

    /** 身份证地址 */
    @Excel(name = "身份证地址")
    private String address;

    /** 身份类型 */
    @Excel(name = "身份类型")
    private Integer identityType; //身份类型 1=员工 2=访客 默认为1
}
