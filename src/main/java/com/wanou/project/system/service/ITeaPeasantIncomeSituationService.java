package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaPeasantIncomeSituation;

/**
 * 人均收入情况Service接口
 * 
 * @author ruoyi
 * @date 2022-04-02
 */
public interface ITeaPeasantIncomeSituationService 
{
    /**
     * 查询人均收入情况
     * 
     * @param id 人均收入情况主键
     * @return 人均收入情况
     */
    public TeaPeasantIncomeSituation selectTeaPeasantIncomeSituationById(Long id);

    /**
     * 查询人均收入情况列表
     * 
     * @param teaPeasantIncomeSituation 人均收入情况
     * @return 人均收入情况集合
     */
    public List<TeaPeasantIncomeSituation> selectTeaPeasantIncomeSituationList(TeaPeasantIncomeSituation teaPeasantIncomeSituation);

    /**
     * 新增人均收入情况
     * 
     * @param teaPeasantIncomeSituation 人均收入情况
     * @return 结果
     */
    public int insertTeaPeasantIncomeSituation(TeaPeasantIncomeSituation teaPeasantIncomeSituation);

    /**
     * 修改人均收入情况
     * 
     * @param teaPeasantIncomeSituation 人均收入情况
     * @return 结果
     */
    public int updateTeaPeasantIncomeSituation(TeaPeasantIncomeSituation teaPeasantIncomeSituation);

    /**
     * 批量删除人均收入情况
     * 
     * @param ids 需要删除的人均收入情况主键集合
     * @return 结果
     */
    public int deleteTeaPeasantIncomeSituationByIds(Long[] ids);

    /**
     * 删除人均收入情况信息
     * 
     * @param id 人均收入情况主键
     * @return 结果
     */
    public int deleteTeaPeasantIncomeSituationById(Long id);
}
