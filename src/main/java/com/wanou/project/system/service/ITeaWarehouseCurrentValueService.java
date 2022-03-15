package com.wanou.project.system.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.wanou.project.system.domain.TeaWarehouseCurrentValue;

/**
 * 当前库存情况货值分布Service接口
 *
 * @author ruoyi
 * @date 2022-03-07
 */
public interface ITeaWarehouseCurrentValueService
{
    /**
     * 查询当前库存情况货值分布
     *
     * @param id 当前库存情况货值分布主键
     * @return 当前库存情况货值分布
     */
    public TeaWarehouseCurrentValue selectTeaWarehouseCurrentValueById(Long id);

    /**
     * 查询当前库存情况货值分布列表
     *
     * @param teaWarehouseCurrentValue 当前库存情况货值分布
     * @return 当前库存情况货值分布集合
     */
    public List<TeaWarehouseCurrentValue> selectTeaWarehouseCurrentValueList(TeaWarehouseCurrentValue teaWarehouseCurrentValue);

    /**
     * 新增当前库存情况货值分布
     *
     * @param teaWarehouseCurrentValue 当前库存情况货值分布
     * @return 结果
     */
    public int insertTeaWarehouseCurrentValue(TeaWarehouseCurrentValue teaWarehouseCurrentValue);

    /**
     * 修改当前库存情况货值分布
     *
     * @param teaWarehouseCurrentValue 当前库存情况货值分布
     * @return 结果
     */
    public int updateTeaWarehouseCurrentValue(TeaWarehouseCurrentValue teaWarehouseCurrentValue);

    /**
     * 批量删除当前库存情况货值分布
     *
     * @param ids 需要删除的当前库存情况货值分布主键集合
     * @return 结果
     */
    public int deleteTeaWarehouseCurrentValueByIds(Long[] ids);

    /**
     * 删除当前库存情况货值分布信息
     *
     * @param id 当前库存情况货值分布主键
     * @return 结果
     */
    public int deleteTeaWarehouseCurrentValueById(Long id);

    List<JSONObject> getValueDistribution(int teaWarehouseId);
}
