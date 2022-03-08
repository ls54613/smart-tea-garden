package com.wanou.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 tea_garden
 *
 * @author ruoyi
 * @date 2022-03-03
 */
public class TeaGarden extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 茶园id */
    private Long teaGardenId;

    /** 企业单位 */
    @Excel(name = "企业单位")
    private String enterprises;

    /** 茶园面积 */
    @Excel(name = "茶园面积")
    private Long teaArea;

    /** 茶树品种 */
    @Excel(name = "茶树品种")
    private Long teaTreeVariety;

    /** 从业人数 */
    @Excel(name = "从业人数")
    private Long employNum;

    /** 设施数量 */
    @Excel(name = "设施数量")
    private Long facilitiesNum;

    /** 年均产量 */
    @Excel(name = "年均产量")
    private Long averageYield;

    /** 预计总产量 */
    @Excel(name = "预计总产量")
    private String totalProduction;

    /** 茶园类型 */
    @Excel(name = "茶园类型")
    private Long teaType;

    /** 负责人 */
    @Excel(name = "负责人")
    private String head;

    public void setTeaGardenId(Long teaGardenId)
    {
        this.teaGardenId = teaGardenId;
    }

    public Long getTeaGardenId()
    {
        return teaGardenId;
    }
    public void setEnterprises(String enterprises)
    {
        this.enterprises = enterprises;
    }

    public String getEnterprises()
    {
        return enterprises;
    }
    public void setTeaArea(Long teaArea)
    {
        this.teaArea = teaArea;
    }

    public Long getTeaArea()
    {
        return teaArea;
    }
    public void setTeaTreeVariety(Long teaTreeVariety)
    {
        this.teaTreeVariety = teaTreeVariety;
    }

    public Long getTeaTreeVariety()
    {
        return teaTreeVariety;
    }
    public void setEmployNum(Long employNum)
    {
        this.employNum = employNum;
    }

    public Long getEmployNum()
    {
        return employNum;
    }
    public void setFacilitiesNum(Long facilitiesNum)
    {
        this.facilitiesNum = facilitiesNum;
    }

    public Long getFacilitiesNum()
    {
        return facilitiesNum;
    }
    public void setAverageYield(Long averageYield)
    {
        this.averageYield = averageYield;
    }

    public Long getAverageYield()
    {
        return averageYield;
    }
    public void setTotalProduction(String totalProduction)
    {
        this.totalProduction = totalProduction;
    }

    public String getTotalProduction()
    {
        return totalProduction;
    }
    public void setTeaType(Long teaType)
    {
        this.teaType = teaType;
    }

    public Long getTeaType()
    {
        return teaType;
    }
    public void setHead(String head)
    {
        this.head = head;
    }

    public String getHead()
    {
        return head;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("teaGardenId", getTeaGardenId())
            .append("enterprises", getEnterprises())
            .append("teaArea", getTeaArea())
            .append("teaTreeVariety", getTeaTreeVariety())
            .append("employNum", getEmployNum())
            .append("facilitiesNum", getFacilitiesNum())
            .append("averageYield", getAverageYield())
            .append("totalProduction", getTotalProduction())
            .append("teaType", getTeaType())
            .append("head", getHead())
            .toString();
    }
}
