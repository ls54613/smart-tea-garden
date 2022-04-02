package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaPeasantIncomeSituationMapper;
import com.wanou.project.system.domain.TeaPeasantIncomeSituation;
import com.wanou.project.system.service.ITeaPeasantIncomeSituationService;

/**
 * 人均收入情况Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-02
 */
@Service
public class TeaPeasantIncomeSituationServiceImpl implements ITeaPeasantIncomeSituationService
{
    @Autowired
    private TeaPeasantIncomeSituationMapper teaPeasantIncomeSituationMapper;

    /**
     * 查询人均收入情况
     *
     * @param id 人均收入情况主键
     * @return 人均收入情况
     */
    @Override
    public TeaPeasantIncomeSituation selectTeaPeasantIncomeSituationById(Long id)
    {
        return teaPeasantIncomeSituationMapper.selectTeaPeasantIncomeSituationById(id);
    }

    /**
     * 查询人均收入情况列表
     *
     * @param teaPeasantIncomeSituation 人均收入情况
     * @return 人均收入情况
     */
    @Override
    public List<TeaPeasantIncomeSituation> selectTeaPeasantIncomeSituationList(TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        return teaPeasantIncomeSituationMapper.selectTeaPeasantIncomeSituationList(teaPeasantIncomeSituation);
    }

    /**
     * 新增人均收入情况
     *
     * @param teaPeasantIncomeSituation 人均收入情况
     * @return 结果
     */
    @Override
    public int insertTeaPeasantIncomeSituation(TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        return teaPeasantIncomeSituationMapper.insertTeaPeasantIncomeSituation(teaPeasantIncomeSituation);
    }

    /**
     * 修改人均收入情况
     *
     * @param teaPeasantIncomeSituation 人均收入情况
     * @return 结果
     */
    @Override
    public int updateTeaPeasantIncomeSituation(TeaPeasantIncomeSituation teaPeasantIncomeSituation)
    {
        return teaPeasantIncomeSituationMapper.updateTeaPeasantIncomeSituation(teaPeasantIncomeSituation);
    }

    /**
     * 批量删除人均收入情况
     *
     * @param ids 需要删除的人均收入情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantIncomeSituationByIds(Long[] ids)
    {
        return teaPeasantIncomeSituationMapper.deleteTeaPeasantIncomeSituationByIds(ids);
    }

    /**
     * 删除人均收入情况信息
     *
     * @param id 人均收入情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaPeasantIncomeSituationById(Long id)
    {
        return teaPeasantIncomeSituationMapper.deleteTeaPeasantIncomeSituationById(id);
    }
}
