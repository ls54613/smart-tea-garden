package com.wanou.project.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 人员管理Excel tx_person
 *
 * @author wanou
 * @date 2021-08-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TxPersonExcel extends BaseEntity
{


    private static final long serialVersionUID = 7062099713198022528L;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idcardNum;

    /** 手机号 */
    @Excel(name = "手机号")
    private String mobile;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 部门名称 */
    @Excel(name = "部门id")
    private Long departmentId;

    /** 通行区域 */
    @Excel(name = "通行区域,请填写区域id,多个请用英文,分隔")
    private String domainId;

    /** 人员性别 */
    @Excel(name = "人员性别 0=男 1=女")
    private Integer sex;

    /** 身份证地址 */
    @Excel(name = "身份证上的地址")
    private String address;
}
