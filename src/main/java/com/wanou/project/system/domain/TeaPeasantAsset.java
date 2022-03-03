package com.wanou.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 茶农资产状况对象 tea_peasant_asset
 *
 * @author MrYao
 * @date 2022-03-02
 */
public class TeaPeasantAsset extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 资产状况id */
    private Long id;

    /** 资产类型 */
    @Excel(name = "资产类型")
    private String assetsType;

    /** 资产内容 */
    @Excel(name = "资产内容")
    private String content;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 关联茶农id */
    @Excel(name = "关联茶农id")
    private Long teaPeasantId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAssetsType(String assetsType)
    {
        this.assetsType = assetsType;
    }

    public String getAssetsType()
    {
        return assetsType;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }
    public void setTeaPeasantId(Long teaPeasantId)
    {
        this.teaPeasantId = teaPeasantId;
    }

    public Long getTeaPeasantId()
    {
        return teaPeasantId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("assetsType", getAssetsType())
            .append("content", getContent())
            .append("remarks", getRemarks())
            .append("teaPeasantId", getTeaPeasantId())
            .toString();
    }
}
