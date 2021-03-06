package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaWarehouseDetails;

/**
 * 茶仓详情Service接口
 * 
 * @author ruoyi
 * @date 2022-03-07
 */
public interface ITeaWarehouseDetailsService 
{
    /**
     * 查询茶仓详情
     * 
     * @param id 茶仓详情主键
     * @return 茶仓详情
     */
    public TeaWarehouseDetails selectTeaWarehouseDetailsById(Long id);

    /**
     * 查询茶仓详情列表
     * 
     * @param teaWarehouseDetails 茶仓详情
     * @return 茶仓详情集合
     */
    public List<TeaWarehouseDetails> selectTeaWarehouseDetailsList(TeaWarehouseDetails teaWarehouseDetails);

    /**
     * 新增茶仓详情
     * 
     * @param teaWarehouseDetails 茶仓详情
     * @return 结果
     */
    public int insertTeaWarehouseDetails(TeaWarehouseDetails teaWarehouseDetails);

    /**
     * 修改茶仓详情
     * 
     * @param teaWarehouseDetails 茶仓详情
     * @return 结果
     */
    public int updateTeaWarehouseDetails(TeaWarehouseDetails teaWarehouseDetails);

    /**
     * 批量删除茶仓详情
     * 
     * @param ids 需要删除的茶仓详情主键集合
     * @return 结果
     */
    public int deleteTeaWarehouseDetailsByIds(Long[] ids);

    /**
     * 删除茶仓详情信息
     * 
     * @param id 茶仓详情主键
     * @return 结果
     */
    public int deleteTeaWarehouseDetailsById(Long id);
}
