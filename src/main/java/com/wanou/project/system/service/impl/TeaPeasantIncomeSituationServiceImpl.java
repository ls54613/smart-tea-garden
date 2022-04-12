package com.wanou.project.system.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaPeasantIncomeSituationMapper;
import com.wanou.project.system.domain.TeaPeasantIncomeSituation;
import com.wanou.project.system.service.ITeaPeasantIncomeSituationService;

/**
 * 常宁茶农人均收入与总体人均收入Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-06
 */
@Service
public class TeaPeasantIncomeSituationServiceImpl implements ITeaPeasantIncomeSituationService
{
    @Autowired
    private TeaPeasantIncomeSituationMapper teaPeasantIncomeSituationMapper;

    /**
     * 查询常宁茶农人均收入与总体人均收入
     *
     * @param id 常宁茶农人均收入与总体人均收入主键
     * @return 常宁茶农人均收入与总体人均收入
     */
    @Override
    public TeaPeasantIncomeSituation selectTeaPeasantIncomeSituationById(Long id)
    {
        return teaPeasantIncomeSituationMapper.selectTeaPeasantIncomeSituationById(id);
    }

    /**
     * 查询常宁茶农人均收入与总体人均收入列表
     *
     * @param teaPeasantIncomeSituation 常宁茶农人均收入与总体人均收入
     * @return 常宁茶农人均收入与总体人均收入
     */
    @Override
    public List<TeaPeasantIncomeSituation> selectTeaPeasantIncomeSituationList(TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        return teaPeasantIncomeSituationMapper.selectTeaPeasantIncomeSituationList(teaPeasantIncomeSituation);
    }

    /**
     * 新增常宁茶农人均收入与总体人均收入
     *
     * @param teaPeasantIncomeSituation 常宁茶农人均收入与总体人均收入
     * @return 结果
     */
    @Override
    public int insertTeaPeasantIncomeSituation(TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        return teaPeasantIncomeSituationMapper.insertTeaPeasantIncomeSituation(teaPeasantIncomeSituation);
    }

    /**
     * 修改常宁茶农人均收入与总体人均收入
     *
     * @param teaPeasantIncomeSituation 常宁茶农人均收入与总体人均收入
     * @return 结果
     */
    @Override
    public int updateTeaPeasantIncomeSituation(TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        return teaPeasantIncomeSituationMapper.updateTeaPeasantIncomeSituation(teaPeasantIncomeSituation);
    }

    /**
     * 批量删除常宁茶农人均收入与总体人均收入
     *
     * @param ids 需要删除的常宁茶农人均收入与总体人均收入主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantIncomeSituationByIds(Long[] ids)
    {
        return teaPeasantIncomeSituationMapper.deleteTeaPeasantIncomeSituationByIds(ids);
    }

    /**
     * 删除常宁茶农人均收入与总体人均收入信息
     *
     * @param id 常宁茶农人均收入与总体人均收入主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantIncomeSituationById(Long id)
    {
        return teaPeasantIncomeSituationMapper.deleteTeaPeasantIncomeSituationById(id);
    }

    @Override
    public List<JSONObject> getPeasantIncomeSituationService() {
        return teaPeasantIncomeSituationMapper.getPeasantIncomeSituationService();
    }
}
