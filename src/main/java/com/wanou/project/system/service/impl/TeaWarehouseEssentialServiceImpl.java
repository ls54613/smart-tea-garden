package com.wanou.project.system.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.wanou.project.system.domain.openApi.TeaValueDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaWarehouseEssentialMapper;
import com.wanou.project.system.domain.TeaWarehouseEssential;
import com.wanou.project.system.service.ITeaWarehouseEssentialService;

/**
 * 茶仓基本情况Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-07
 */
@Service
public class TeaWarehouseEssentialServiceImpl implements ITeaWarehouseEssentialService
{
    @Autowired
    private TeaWarehouseEssentialMapper teaWarehouseEssentialMapper;

    /**
     * 查询茶仓基本情况
     *
     * @param id 茶仓基本情况主键
     * @return 茶仓基本情况
     */
    @Override
    public TeaWarehouseEssential selectTeaWarehouseEssentialById(Long id)
    {
        return teaWarehouseEssentialMapper.selectTeaWarehouseEssentialById(id);
    }

    /**
     * 查询茶仓基本情况列表
     *
     * @param teaWarehouseEssential 茶仓基本情况
     * @return 茶仓基本情况
     */
    @Override
    public List<TeaWarehouseEssential> selectTeaWarehouseEssentialList(TeaWarehouseEssential teaWarehouseEssential)
    {
        return teaWarehouseEssentialMapper.selectTeaWarehouseEssentialList(teaWarehouseEssential);
    }

    /**
     * 新增茶仓基本情况
     *
     * @param teaWarehouseEssential 茶仓基本情况
     * @return 结果
     */
    @Override
    public int insertTeaWarehouseEssential(TeaWarehouseEssential teaWarehouseEssential)
    {
        return teaWarehouseEssentialMapper.insertTeaWarehouseEssential(teaWarehouseEssential);
    }

    /**
     * 修改茶仓基本情况
     *
     * @param teaWarehouseEssential 茶仓基本情况
     * @return 结果
     */
    @Override
    public int updateTeaWarehouseEssential(TeaWarehouseEssential teaWarehouseEssential)
    {
        return teaWarehouseEssentialMapper.updateTeaWarehouseEssential(teaWarehouseEssential);
    }

    /**
     * 批量删除茶仓基本情况
     *
     * @param ids 需要删除的茶仓基本情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaWarehouseEssentialByIds(Long[] ids)
    {
        return teaWarehouseEssentialMapper.deleteTeaWarehouseEssentialByIds(ids);
    }

    /**
     * 删除茶仓基本情况信息
     *
     * @param id 茶仓基本情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaWarehouseEssentialById(Long id)
    {
        return teaWarehouseEssentialMapper.deleteTeaWarehouseEssentialById(id);
    }

    @Override
    public JSONObject getWarehouseInformation(long id) {
        return teaWarehouseEssentialMapper.getWarehouseInformation(id);
    }

    @Override
    public List<TeaValueDistribution> getValueDistribution() {
        return teaWarehouseEssentialMapper.getValueDistribution();
    }

    @Override
    public JSONObject getTeaWarehouse(int teaEnterpriseId) {
        return teaWarehouseEssentialMapper.getTeaWarehouse(teaEnterpriseId);
    }

    @Override
    public List<JSONObject> getWarehouseInAndOutWarning(int teaWarehouseId) {
        return teaWarehouseEssentialMapper.getWarehouseInAndOutWarning(teaWarehouseId);
    }

    @Override
    public List<JSONObject> getCapacityAndWarehousingAndOut(int teaWarehouseId) {
        return teaWarehouseEssentialMapper.getCapacityAndWarehousingAndOut(teaWarehouseId);
    }
}
