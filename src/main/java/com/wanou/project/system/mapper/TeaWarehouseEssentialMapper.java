package com.wanou.project.system.mapper;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.wanou.project.system.domain.TeaWarehouseEssential;
import com.wanou.project.system.domain.openApi.TeaValueDistribution;

/**
 * 茶仓基本情况Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-07
 */
public interface TeaWarehouseEssentialMapper
{
    /**
     * 查询茶仓基本情况
     *
     * @param id 茶仓基本情况主键
     * @return 茶仓基本情况
     */
    public TeaWarehouseEssential selectTeaWarehouseEssentialById(Long id);

    /**
     * 查询茶仓基本情况列表
     *
     * @param teaWarehouseEssential 茶仓基本情况
     * @return 茶仓基本情况集合
     */
    public List<TeaWarehouseEssential> selectTeaWarehouseEssentialList(TeaWarehouseEssential teaWarehouseEssential);

    /**
     * 新增茶仓基本情况
     *
     * @param teaWarehouseEssential 茶仓基本情况
     * @return 结果
     */
    public int insertTeaWarehouseEssential(TeaWarehouseEssential teaWarehouseEssential);

    /**
     * 修改茶仓基本情况
     *
     * @param teaWarehouseEssential 茶仓基本情况
     * @return 结果
     */
    public int updateTeaWarehouseEssential(TeaWarehouseEssential teaWarehouseEssential);

    /**
     * 删除茶仓基本情况
     *
     * @param id 茶仓基本情况主键
     * @return 结果
     */
    public int deleteTeaWarehouseEssentialById(Long id);

    /**
     * 批量删除茶仓基本情况
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaWarehouseEssentialByIds(Long[] ids);

    public JSONObject getWarehouseInformation(long id);

    public List<TeaValueDistribution> getValueDistribution();
}
