package com.wanou.project.system.service.impl;

import java.util.List;

import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaMarketScaleMapper;
import com.wanou.project.system.domain.TeaMarketScale;
import com.wanou.project.system.service.ITeaMarketScaleService;

/**
 * 中国茶叶线上销售规模监测数据Service业务层处理
 *
 * @author MrYao
 * @date 2022-04-06
 */
@Service
public class TeaMarketScaleServiceImpl implements ITeaMarketScaleService
{
    @Autowired
    private TeaMarketScaleMapper teaMarketScaleMapper;

    /**
     * 查询中国茶叶线上销售规模监测数据
     *
     * @param id 中国茶叶线上销售规模监测数据主键
     * @return 中国茶叶线上销售规模监测数据
     */
    @Override
    public TeaMarketScale selectTeaMarketScaleById(Long id)
    {
        return teaMarketScaleMapper.selectTeaMarketScaleById(id);
    }

    /**
     * 查询中国茶叶线上销售规模监测数据列表
     *
     * @param teaMarketScale 中国茶叶线上销售规模监测数据
     * @return 中国茶叶线上销售规模监测数据
     */
    @Override
    public List<TeaMarketScale> selectTeaMarketScaleList(TeaMarketScale teaMarketScale)
    {
        return teaMarketScaleMapper.selectTeaMarketScaleList(teaMarketScale);
    }

    /**
     * 新增中国茶叶线上销售规模监测数据
     *
     * @param teaMarketScale 中国茶叶线上销售规模监测数据
     * @return 结果
     */
    @Override
    public int insertTeaMarketScale(TeaMarketScale teaMarketScale)
    {
        return teaMarketScaleMapper.insertTeaMarketScale(teaMarketScale);
    }

    /**
     * 修改中国茶叶线上销售规模监测数据
     *
     * @param teaMarketScale 中国茶叶线上销售规模监测数据
     * @return 结果
     */
    @Override
    public int updateTeaMarketScale(TeaMarketScale teaMarketScale)
    {
        return teaMarketScaleMapper.updateTeaMarketScale(teaMarketScale);
    }

    /**
     * 批量删除中国茶叶线上销售规模监测数据
     *
     * @param ids 需要删除的中国茶叶线上销售规模监测数据主键
     * @return 结果
     */
    @Override
    public int deleteTeaMarketScaleByIds(Long[] ids)
    {
        return teaMarketScaleMapper.deleteTeaMarketScaleByIds(ids);
    }

    /**
     * 删除中国茶叶线上销售规模监测数据信息
     *
     * @param id 中国茶叶线上销售规模监测数据主键
     * @return 结果
     */
    @Override
    public int deleteTeaMarketScaleById(Long id)
    {
        return teaMarketScaleMapper.deleteTeaMarketScaleById(id);
    }

    @Override
    public List<JSONObject> getOnlineSalesTestData() {
        return teaMarketScaleMapper.getOnlineSalesTestData();
    }
}
