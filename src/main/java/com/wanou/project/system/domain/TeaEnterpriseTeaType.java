package com.wanou.project.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶企茶叶种类对象 tea_enterprise_tea_type
 *
 * @author ruoyi
 * @date 2022-03-05
 */
@Data
public class TeaEnterpriseTeaType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 关联茶企id */
    @Excel(name = "关联茶企id")
    private Long teaEnterpriseId;

    /** 茶种类1=碧香早2=楮叶齐3=黄金茶4=安吉白茶 */
    @Excel(name = "茶种类1=碧香早2=楮叶齐3=黄金茶4=安吉白茶")
    private Long teaType;
}
