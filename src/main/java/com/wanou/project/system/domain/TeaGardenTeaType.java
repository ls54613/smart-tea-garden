package com.wanou.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶园种植种类占比对象 tea_garden_tea_type
 *
 * @author ruoyi
 * @date 2022-03-14
 */
public class TeaGardenTeaType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 关联茶园 */
    @Excel(name = "关联茶园")
    private Long teaGardenId;

    /** 茶种类 */
    @Excel(name = "茶种类")
    private Integer type;

    /** 占比(%) */
    @Excel(name = "占比(%)")
    private Long proportion;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTeaGardenId(Long teaGardenId)
    {
        this.teaGardenId = teaGardenId;
    }

    public Long getTeaGardenId()
    {
        return teaGardenId;
    }
    public void setType(Integer type)
    {
        this.type = type;
    }

    public Integer getType()
    {
        return type;
    }
    public void setProportion(Long proportion)
    {
        this.proportion = proportion;
    }

    public Long getProportion()
    {
        return proportion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teaGardenId", getTeaGardenId())
            .append("type", getType())
            .append("proportion", getProportion())
            .toString();
    }
}
