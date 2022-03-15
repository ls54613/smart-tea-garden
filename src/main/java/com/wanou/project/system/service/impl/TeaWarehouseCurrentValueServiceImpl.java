package com.wanou.project.system.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaWarehouseCurrentValueMapper;
import com.wanou.project.system.domain.TeaWarehouseCurrentValue;
import com.wanou.project.system.service.ITeaWarehouseCurrentValueService;

/**
 * 当前库存情况货值分布Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-07
 */
@Service
public class TeaWarehouseCurrentValueServiceImpl implements ITeaWarehouseCurrentValueService
{
    @Autowired
    private TeaWarehouseCurrentValueMapper teaWarehouseCurrentValueMapper;

    /**
     * 查询当前库存情况货值分布
     *
     * @param id 当前库存情况货值分布主键
     * @return 当前库存情况货值分布
     */
    @Override
    public TeaWarehouseCurrentValue selectTeaWarehouseCurrentValueById(Long id)
    {
        return teaWarehouseCurrentValueMapper.selectTeaWarehouseCurrentValueById(id);
    }

    /**
     * 查询当前库存情况货值分布列表
     *
     * @param teaWarehouseCurrentValue 当前库存情况货值分布
     * @return 当前库存情况货值分布
     */
    @Override
    public List<TeaWarehouseCurrentValue> selectTeaWarehouseCurrentValueList(TeaWarehouseCurrentValue teaWarehouseCurrentValue)
    {
        return teaWarehouseCurrentValueMapper.selectTeaWarehouseCurrentValueList(teaWarehouseCurrentValue);
    }

    /**
     * 新增当前库存情况货值分布
     *
     * @param teaWarehouseCurrentValue 当前库存情况货值分布
     * @return 结果
     */
    @Override
    public int insertTeaWarehouseCurrentValue(TeaWarehouseCurrentValue teaWarehouseCurrentValue)
    {
        return teaWarehouseCurrentValueMapper.insertTeaWarehouseCurrentValue(teaWarehouseCurrentValue);
    }

    /**
     * 修改当前库存情况货值分布
     *
     * @param teaWarehouseCurrentValue 当前库存情况货值分布
     * @return 结果
     */
    @Override
    public int updateTeaWarehouseCurrentValue(TeaWarehouseCurrentValue teaWarehouseCurrentValue)
    {
        return teaWarehouseCurrentValueMapper.updateTeaWarehouseCurrentValue(teaWarehouseCurrentValue);
    }

    /**
     * 批量删除当前库存情况货值分布
     *
     * @param ids 需要删除的当前库存情况货值分布主键
     * @return 结果
     */
    @Override
    public int deleteTeaWarehouseCurrentValueByIds(Long[] ids)
    {
        return teaWarehouseCurrentValueMapper.deleteTeaWarehouseCurrentValueByIds(ids);
    }

    /**
     * 删除当前库存情况货值分布信息
     *
     * @param id 当前库存情况货值分布主键
     * @return 结果
     */
    @Override
    public int deleteTeaWarehouseCurrentValueById(Long id)
    {
        return teaWarehouseCurrentValueMapper.deleteTeaWarehouseCurrentValueById(id);
    }

    @Override
    public List<JSONObject> getValueDistribution(int teaWarehouseId) {
        return teaWarehouseCurrentValueMapper.getValueDistribution(teaWarehouseId);
    }
}
