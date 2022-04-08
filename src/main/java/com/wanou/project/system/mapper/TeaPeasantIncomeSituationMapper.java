package com.wanou.project.system.mapper;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.wanou.project.system.domain.TeaPeasantIncomeSituation;

/**
 * 常宁茶农人均收入与总体人均收入Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-06
 */
public interface TeaPeasantIncomeSituationMapper
{
    /**
     * 查询常宁茶农人均收入与总体人均收入
     *
     * @param id 常宁茶农人均收入与总体人均收入主键
     * @return 常宁茶农人均收入与总体人均收入
     */
    public TeaPeasantIncomeSituation selectTeaPeasantIncomeSituationById(Long id);

    /**
     * 查询常宁茶农人均收入与总体人均收入列表
     *
     * @param teaPeasantIncomeSituation 常宁茶农人均收入与总体人均收入
     * @return 常宁茶农人均收入与总体人均收入集合
     */
    public List<TeaPeasantIncomeSituation> selectTeaPeasantIncomeSituationList(TeaPeasantIncomeSituation teaPeasantIncomeSituation);

    /**
     * 新增常宁茶农人均收入与总体人均收入
     *
     * @param teaPeasantIncomeSituation 常宁茶农人均收入与总体人均收入
     * @return 结果
     */
    public int insertTeaPeasantIncomeSituation(TeaPeasantIncomeSituation teaPeasantIncomeSituation);

    /**
     * 修改常宁茶农人均收入与总体人均收入
     *
     * @param teaPeasantIncomeSituation 常宁茶农人均收入与总体人均收入
     * @return 结果
     */
    public int updateTeaPeasantIncomeSituation(TeaPeasantIncomeSituation teaPeasantIncomeSituation);

    /**
     * 删除常宁茶农人均收入与总体人均收入
     *
     * @param id 常宁茶农人均收入与总体人均收入主键
     * @return 结果
     */
    public int deleteTeaPeasantIncomeSituationById(Long id);

    /**
     * 批量删除常宁茶农人均收入与总体人均收入
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaPeasantIncomeSituationByIds(Long[] ids);

    List<JSONObject> getPeasantIncomeSituationService();
}
