package com.wanou.project.system.service;

import java.util.List;

import cn.hutool.json.JSONObject;
import com.wanou.project.system.domain.TeaGarden;
import com.wanou.project.system.domain.vo.TeaGardenVo;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2022-03-03
 */
public interface ITeaGardenService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param teaGardenId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TeaGarden selectTeaGardenByTeaGardenId(Long teaGardenId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param teaGarden 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TeaGarden> selectTeaGardenList(TeaGarden teaGarden);

    /**
     * 新增【请填写功能名称】
     *
     * @param teaGarden 【请填写功能名称】
     * @return 结果
     */
    public int insertTeaGarden(TeaGarden teaGarden);

    /**
     * 修改【请填写功能名称】
     *
     * @param teaGarden 【请填写功能名称】
     * @return 结果
     */
    public int updateTeaGarden(TeaGarden teaGarden);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param teaGardenIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTeaGardenByTeaGardenIds(Long[] teaGardenIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param teaGardenId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTeaGardenByTeaGardenId(Long teaGardenId);

    List<TeaGardenVo> listTeaGarden(TeaGarden teaGarden);

    List<JSONObject> getEnterpriseNameAndArea();

    List<JSONObject> getRegionAverageYieldAndTeaArea();

    List<JSONObject> getProportionYieldAndDictLabel();

    JSONObject getTeaGardenInformation(String name);
}
