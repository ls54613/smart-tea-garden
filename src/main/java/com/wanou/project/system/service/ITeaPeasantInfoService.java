package com.wanou.project.system.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.wanou.project.system.domain.TeaPeasantInfo;
import com.wanou.project.system.domain.openApi.TeaPeasantEducation;
import com.wanou.project.system.domain.openApi.TeaPeasantRegionYieldValue;
import com.wanou.project.system.domain.openApi.TeaPersonalInformation;

/**
 * 茶农基本信息Service接口
 *
 * @author ruoyi
 * @date 2022-03-02
 */
public interface ITeaPeasantInfoService
{
    /**
     * 查询茶农基本信息
     *
     * @param id 茶农基本信息主键
     * @return 茶农基本信息
     */
    public TeaPeasantInfo selectTeaPeasantInfoById(Long id);

    /**
     * 查询茶农基本信息列表
     *
     * @param teaPeasantInfo 茶农基本信息
     * @return 茶农基本信息集合
     */
    public List<TeaPeasantInfo> selectTeaPeasantInfoList(TeaPeasantInfo teaPeasantInfo);

    /**
     * 新增茶农基本信息
     *
     * @param teaPeasantInfo 茶农基本信息
     * @return 结果
     */
    public int insertTeaPeasantInfo(TeaPeasantInfo teaPeasantInfo);

    /**
     * 修改茶农基本信息
     *
     * @param teaPeasantInfo 茶农基本信息
     * @return 结果
     */
    public int updateTeaPeasantInfo(TeaPeasantInfo teaPeasantInfo);

    /**
     * 批量删除茶农基本信息
     *
     * @param ids 需要删除的茶农基本信息主键集合
     * @return 结果
     */
    public int deleteTeaPeasantInfoByIds(Long[] ids);

    /**
     * 删除茶农基本信息信息
     *
     * @param id 茶农基本信息主键
     * @return 结果
     */
    public int deleteTeaPeasantInfoById(Long id);

    /**
     * 获取茶农文化程度统计
     * */
    public List<JSONObject> getPeasantEducation();

    public int getTotalNumber();


    public TeaPersonalInformation getTeaPersonalInformation(int id);

    List<TeaPeasantRegionYieldValue> getPeasantRegionYieldValue();

    JSONObject getLargeHouseholdIncome();
}
