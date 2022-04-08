package com.wanou.project.system.service.impl;

import java.util.List;

import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaMarketPreferenceRateMapper;
import com.wanou.project.system.domain.TeaMarketPreferenceRate;
import com.wanou.project.system.service.ITeaMarketPreferenceRateService;

/**
 * 中国茶叶线上销售品类数据监测Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-06
 */
@Service
public class TeaMarketPreferenceRateServiceImpl implements ITeaMarketPreferenceRateService
{
    @Autowired
    private TeaMarketPreferenceRateMapper teaMarketPreferenceRateMapper;

    /**
     * 查询中国茶叶线上销售品类数据监测
     *
     * @param id 中国茶叶线上销售品类数据监测主键
     * @return 中国茶叶线上销售品类数据监测
     */
    @Override
    public TeaMarketPreferenceRate selectTeaMarketPreferenceRateById(Long id)
    {
        return teaMarketPreferenceRateMapper.selectTeaMarketPreferenceRateById(id);
    }

    /**
     * 查询中国茶叶线上销售品类数据监测列表
     *
     * @param teaMarketPreferenceRate 中国茶叶线上销售品类数据监测
     * @return 中国茶叶线上销售品类数据监测
     */
    @Override
    public List<TeaMarketPreferenceRate> selectTeaMarketPreferenceRateList(TeaMarketPreferenceRate teaMarketPreferenceRate)
    {
        return teaMarketPreferenceRateMapper.selectTeaMarketPreferenceRateList(teaMarketPreferenceRate);
    }

    /**
     * 新增中国茶叶线上销售品类数据监测
     *
     * @param teaMarketPreferenceRate 中国茶叶线上销售品类数据监测
     * @return 结果
     */
    @Override
    public int insertTeaMarketPreferenceRate(TeaMarketPreferenceRate teaMarketPreferenceRate)
    {
        return teaMarketPreferenceRateMapper.insertTeaMarketPreferenceRate(teaMarketPreferenceRate);
    }

    /**
     * 修改中国茶叶线上销售品类数据监测
     *
     * @param teaMarketPreferenceRate 中国茶叶线上销售品类数据监测
     * @return 结果
     */
    @Override
    public int updateTeaMarketPreferenceRate(TeaMarketPreferenceRate teaMarketPreferenceRate)
    {
        return teaMarketPreferenceRateMapper.updateTeaMarketPreferenceRate(teaMarketPreferenceRate);
    }

    /**
     * 批量删除中国茶叶线上销售品类数据监测
     *
     * @param ids 需要删除的中国茶叶线上销售品类数据监测主键
     * @return 结果
     */
    @Override
    public int deleteTeaMarketPreferenceRateByIds(Long[] ids)
    {
        return teaMarketPreferenceRateMapper.deleteTeaMarketPreferenceRateByIds(ids);
    }

    /**
     * 删除中国茶叶线上销售品类数据监测信息
     *
     * @param id 中国茶叶线上销售品类数据监测主键
     * @return 结果
     */
    @Override
    public int deleteTeaMarketPreferenceRateById(Long id)
    {
        return teaMarketPreferenceRateMapper.deleteTeaMarketPreferenceRateById(id);
    }

    @Override
    public List<JSONObject> getSaleTypeTestData() {
        return teaMarketPreferenceRateMapper.getSaleTypeTestData();
    }
}
