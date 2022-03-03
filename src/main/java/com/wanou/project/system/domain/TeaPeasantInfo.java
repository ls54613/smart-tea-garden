package com.wanou.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶农基本信息对象 tea_peasant_info
 *
 * @author ruoyi
 * @date 2022-03-02
 */
public class TeaPeasantInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 所属企业 */
    @Excel(name = "所属企业")
    private Long enterpriseId;

    /** 茶农姓名 */
    @Excel(name = "茶农姓名")
    private String personName;

    /** 茶农性别0=男 1=女 */
    @Excel(name = "茶农性别0=男 1=女 2=未知")
    private Long sex;

    /** 茶农年龄 */
    @Excel(name = "茶农年龄")
    private Long age;

    /** 茶农民族 */
    @Excel(name = "茶农民族")
    private String nation;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicsStatus;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String mobile;

    /** 茶农技能 */
    @Excel(name = "茶农技能")
    private String skill;

    /** 茶农职业 */
    @Excel(name = "茶农职业")
    private String job;

    /** 信誉等级1=极差2=中等3=良好4=优秀5=极好 */
    @Excel(name = "信誉等级1=极差2=中等3=良好4=优秀5=极好")
    private Long creditLevel;

    /** 学历1=小学2=初中3=高中4=大专5=本科6=研究生 */
    @Excel(name = "学历1=小学2=初中3=高中4=大专5=本科6=研究生")
    private Long education;

    /** 照片 */
    @Excel(name = "照片")
    private String pic;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String homeAddress;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEnterpriseId(Long enterpriseId)
    {
        this.enterpriseId = enterpriseId;
    }

    public Long getEnterpriseId()
    {
        return enterpriseId;
    }
    public void setPersonName(String personName)
    {
        this.personName = personName;
    }

    public String getPersonName()
    {
        return personName;
    }
    public void setSex(Long sex)
    {
        this.sex = sex;
    }

    public Long getSex()
    {
        return sex;
    }
    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }
    public void setNation(String nation)
    {
        this.nation = nation;
    }

    public String getNation()
    {
        return nation;
    }
    public void setPoliticsStatus(String politicsStatus)
    {
        this.politicsStatus = politicsStatus;
    }

    public String getPoliticsStatus()
    {
        return politicsStatus;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getMobile()
    {
        return mobile;
    }
    public void setSkill(String skill)
    {
        this.skill = skill;
    }

    public String getSkill()
    {
        return skill;
    }
    public void setJob(String job)
    {
        this.job = job;
    }

    public String getJob()
    {
        return job;
    }
    public void setCreditLevel(Long creditLevel)
    {
        this.creditLevel = creditLevel;
    }

    public Long getCreditLevel()
    {
        return creditLevel;
    }
    public void setEducation(Long education)
    {
        this.education = education;
    }

    public Long getEducation()
    {
        return education;
    }
    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getPic()
    {
        return pic;
    }
    public void setHomeAddress(String homeAddress)
    {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress()
    {
        return homeAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("enterpriseId", getEnterpriseId())
            .append("personName", getPersonName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("nation", getNation())
            .append("politicsStatus", getPoliticsStatus())
            .append("mobile", getMobile())
            .append("skill", getSkill())
            .append("job", getJob())
            .append("creditLevel", getCreditLevel())
            .append("education", getEducation())
            .append("pic", getPic())
            .append("homeAddress", getHomeAddress())
            .toString();
    }
}
