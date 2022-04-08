package com.wanou.project.system.service;

import java.util.List;

import cn.hutool.json.JSONObject;
import com.wanou.project.system.domain.TeaMarketScale;

/**
 * 中国茶叶线上销售规模监测数据Service接口
 *
 * @author MrYao
 * @date 2022-04-06
 */
public interface ITeaMarketScaleService
{
    /**
     * 查询中国茶叶线上销售规模监测数据
     *
     * @param id 中国茶叶线上销售规模监测数据主键
     * @return 中国茶叶线上销售规模监测数据
     */
    public TeaMarketScale selectTeaMarketScaleById(Long id);

    /**
     * 查询中国茶叶线上销售规模监测数据列表
     *
     * @param teaMarketScale 中国茶叶线上销售规模监测数据
     * @return 中国茶叶线上销售规模监测数据集合
     */
    public List<TeaMarketScale> selectTeaMarketScaleList(TeaMarketScale teaMarketScale);

    /**
     * 新增中国茶叶线上销售规模监测数据
     *
     * @param teaMarketScale 中国茶叶线上销售规模监测数据
     * @return 结果
     */
    public int insertTeaMarketScale(TeaMarketScale teaMarketScale);

    /**
     * 修改中国茶叶线上销售规模监测数据
     *
     * @param teaMarketScale 中国茶叶线上销售规模监测数据
     * @return 结果
     */
    public int updateTeaMarketScale(TeaMarketScale teaMarketScale);

    /**
     * 批量删除中国茶叶线上销售规模监测数据
     *
     * @param ids 需要删除的中国茶叶线上销售规模监测数据主键集合
     * @return 结果
     */
    public int deleteTeaMarketScaleByIds(Long[] ids);

    /**
     * 删除中国茶叶线上销售规模监测数据信息
     *
     * @param id 中国茶叶线上销售规模监测数据主键
     * @return 结果
     */
    public int deleteTeaMarketScaleById(Long id);

    List<JSONObject> getOnlineSalesTestData();
}
