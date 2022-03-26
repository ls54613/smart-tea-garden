package com.wanou.project.system.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.wanou.project.system.domain.openApi.TeaPeasantEducation;
import com.wanou.project.system.domain.openApi.TeaPeasantRegionYieldValue;
import com.wanou.project.system.domain.openApi.TeaPersonalInformation;
import com.wanou.project.system.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.domain.TeaPeasantInfo;
import com.wanou.project.system.service.ITeaPeasantInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 茶农基本信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-02
 */
@Service
public class TeaPeasantInfoServiceImpl implements ITeaPeasantInfoService
{
    @Autowired
    private TeaPeasantInfoMapper teaPeasantInfoMapper;
    @Autowired
    private TeaPeasantFamilyMapper teaPeasantFamilyMapper;
    @Autowired
    private TeaPeasantAnnualMapper teaPeasantAnnualMapper;
    @Autowired
    private TeaPeasantAssetMapper teaPeasantAssetMapper;
    @Autowired
    private TeaPeasantYieldSalesMapper teaPeasantYieldSalesMapper;

    /**
     * 查询茶农基本信息
     *
     * @param id 茶农基本信息主键
     * @return 茶农基本信息
     */
    @Override
    public TeaPeasantInfo selectTeaPeasantInfoById(Long id)
    {
        return teaPeasantInfoMapper.selectTeaPeasantInfoById(id);
    }

    /**
     * 查询茶农基本信息列表
     *
     * @param teaPeasantInfo 茶农基本信息
     * @return 茶农基本信息
     */
    @Override
    public List<TeaPeasantInfo> selectTeaPeasantInfoList(TeaPeasantInfo teaPeasantInfo)
    {
        return teaPeasantInfoMapper.selectTeaPeasantInfoList(teaPeasantInfo);
    }

    /**
     * 新增茶农基本信息
     *
     * @param teaPeasantInfo 茶农基本信息
     * @return 结果
     */
    @Override
    public int insertTeaPeasantInfo(TeaPeasantInfo teaPeasantInfo)
    {
        return teaPeasantInfoMapper.insertTeaPeasantInfo(teaPeasantInfo);
    }

    /**
     * 修改茶农基本信息
     *
     * @param teaPeasantInfo 茶农基本信息
     * @return 结果
     */
    @Override
    public int updateTeaPeasantInfo(TeaPeasantInfo teaPeasantInfo)
    {
        return teaPeasantInfoMapper.updateTeaPeasantInfo(teaPeasantInfo);
    }

    /**
     * 批量删除茶农基本信息
     *
     * @param ids 需要删除的茶农基本信息主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteTeaPeasantInfoByIds(Long[] ids)
    {
        int i = teaPeasantInfoMapper.deleteTeaPeasantInfoByIds(ids);
            teaPeasantFamilyMapper.deleteTeapeasantFamilyByPeasantId(ids);
            teaPeasantAnnualMapper.deleteTeaPeasantannualByPeasantId(ids);
            teaPeasantAssetMapper.deleteTeaPeasantAssetByPeasantId(ids);
            teaPeasantYieldSalesMapper.deleteTeaPeasantYieldsalesBYPeasantId(ids);
        return i ;
    }

    /**
     * 删除茶农基本信息信息
     *
     * @param id 茶农基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantInfoById(Long id)
    {
        return teaPeasantInfoMapper.deleteTeaPeasantInfoById(id);
    }

    @Override
    public List<JSONObject> getPeasantEducation() {
        return teaPeasantInfoMapper.getPeasantEducation();
    }

    @Override
    public int getTotalNumber() {
        int totl=teaPeasantInfoMapper.getTotalNumber();
        return totl;
    }

    @Override
    public TeaPersonalInformation getTeaPersonalInformation(int id) {
        return teaPeasantInfoMapper.getTeaPersonalInformation(id);
    }

    @Override
    public List<TeaPeasantRegionYieldValue> getPeasantRegionYieldValue() {
        return teaPeasantInfoMapper.getPeasantRegionYieldValue();
    }

    @Override
    public List<JSONObject> getLargeHouseholdIncome() {
        return teaPeasantInfoMapper.getLargeHouseholdIncome();
    }
}
