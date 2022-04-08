package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TeaWarehouseDetails;
import org.apache.ibatis.annotations.Param;

/**
 * 茶仓详情Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-07
 */
public interface TeaWarehouseDetailsMapper
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
     * 删除茶仓详情
     *
     * @param id 茶仓详情主键
     * @return 结果
     */
    public int deleteTeaWarehouseDetailsById(Long id);

    /**
     * 批量删除茶仓详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaWarehouseDetailsByIds(Long[] ids);

    /**
     * 根据茶仓id批量删除茶仓仓位详情
     * @param ids
     */
    void batchDeleteTeaWarehouseDetailsByTeaWarehouseIds(@Param("teaWarehouseIds") Long[] ids);
}
