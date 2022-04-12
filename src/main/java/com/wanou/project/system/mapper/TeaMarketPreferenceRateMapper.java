package com.wanou.project.system.mapper;

import java.util.List;

import cn.hutool.json.JSONObject;
import com.wanou.project.system.domain.TeaMarketPreferenceRate;

/**
 * 中国茶叶线上销售品类数据监测Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-06
 */
public interface TeaMarketPreferenceRateMapper
{
    /**
     * 查询中国茶叶线上销售品类数据监测
     *
     * @param id 中国茶叶线上销售品类数据监测主键
     * @return 中国茶叶线上销售品类数据监测
     */
    public TeaMarketPreferenceRate selectTeaMarketPreferenceRateById(Long id);

    /**
     * 查询中国茶叶线上销售品类数据监测列表
     *
     * @param teaMarketPreferenceRate 中国茶叶线上销售品类数据监测
     * @return 中国茶叶线上销售品类数据监测集合
     */
    public List<TeaMarketPreferenceRate> selectTeaMarketPreferenceRateList(TeaMarketPreferenceRate teaMarketPreferenceRate);

    /**
     * 新增中国茶叶线上销售品类数据监测
     *
     * @param teaMarketPreferenceRate 中国茶叶线上销售品类数据监测
     * @return 结果
     */
    public int insertTeaMarketPreferenceRate(TeaMarketPreferenceRate teaMarketPreferenceRate);

    /**
     * 修改中国茶叶线上销售品类数据监测
     *
     * @param teaMarketPreferenceRate 中国茶叶线上销售品类数据监测
     * @return 结果
     */
    public int updateTeaMarketPreferenceRate(TeaMarketPreferenceRate teaMarketPreferenceRate);

    /**
     * 删除中国茶叶线上销售品类数据监测
     *
     * @param id 中国茶叶线上销售品类数据监测主键
     * @return 结果
     */
    public int deleteTeaMarketPreferenceRateById(Long id);

    /**
     * 批量删除中国茶叶线上销售品类数据监测
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaMarketPreferenceRateByIds(Long[] ids);

    List<JSONObject> getSaleTypeTestData();
}
