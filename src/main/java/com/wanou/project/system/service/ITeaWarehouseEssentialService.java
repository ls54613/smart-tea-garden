package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaWarehouseEssential;

/**
 * 茶仓基本情况Service接口
 * 
 * @author ruoyi
 * @date 2022-03-07
 */
public interface ITeaWarehouseEssentialService 
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
     * 批量删除茶仓基本情况
     * 
     * @param ids 需要删除的茶仓基本情况主键集合
     * @return 结果
     */
    public int deleteTeaWarehouseEssentialByIds(Long[] ids);

    /**
     * 删除茶仓基本情况信息
     * 
     * @param id 茶仓基本情况主键
     * @return 结果
     */
    public int deleteTeaWarehouseEssentialById(Long id);
}