package com.wanou.project.system.domain.openApi;

import lombok.Data;

import java.io.Serializable;

/**
 * 个人基本信息实体类
 * */
@Data
public class TeaPersonalInformation implements Serializable {
    private static final long serialVersionUID = 7828698283619499551L;

    private Integer id;
    private String teaGrowerName;//茶农姓名
    private Integer teaGrowerSex;
    private String teaGrowerAge;
    private String nation;//民族
    private Integer education;//学历
    private Integer politicsStatus;//政治面貌
    private String mobile;//联系方式
    private String job;//职业
    private String homePhone;//家庭住址
    private String skill;//技能
    private Integer creditLevel;//信誉等级

}
