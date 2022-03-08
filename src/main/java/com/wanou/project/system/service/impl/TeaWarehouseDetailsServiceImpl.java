package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaWarehouseDetailsMapper;
import com.wanou.project.system.domain.TeaWarehouseDetails;
import com.wanou.project.system.service.ITeaWarehouseDetailsService;

/**
 * 茶仓详情Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-07
 */
@Service
public class TeaWarehouseDetailsServiceImpl implements ITeaWarehouseDetailsService
{
    @Autowired
    private TeaWarehouseDetailsMapper teaWarehouseDetailsMapper;

    /**
     * 查询茶仓详情
     *
     * @param id 茶仓详情主键
     * @return 茶仓详情
     */
    @Override
    public TeaWarehouseDetails selectTeaWarehouseDetailsById(Long id)
    {
        return teaWarehouseDetailsMapper.selectTeaWarehouseDetailsById(id);
    }

    /**
     * 查询茶仓详情列表
     *
     * @param teaWarehouseDetails 茶仓详情
     * @return 茶仓详情
     */
    @Override
    public List<TeaWarehouseDetails> selectTeaWarehouseDetailsList(TeaWarehouseDetails teaWarehouseDetails)
    {
        return teaWarehouseDetailsMapper.selectTeaWarehouseDetailsList(teaWarehouseDetails);
    }

    /**
     * 新增茶仓详情
     *
     * @param teaWarehouseDetails 茶仓详情
     * @return 结果
     */
    @Override
    public int insertTeaWarehouseDetails(TeaWarehouseDetails teaWarehouseDetails)
    {
        return teaWarehouseDetailsMapper.insertTeaWarehouseDetails(teaWarehouseDetails);
    }

    /**
     * 修改茶仓详情
     *
     * @param teaWarehouseDetails 茶仓详情
     * @return 结果
     */
    @Override
    public int updateTeaWarehouseDetails(TeaWarehouseDetails teaWarehouseDetails)
    {
        return teaWarehouseDetailsMapper.updateTeaWarehouseDetails(teaWarehouseDetails);
    }

    /**
     * 批量删除茶仓详情
     *
     * @param ids 需要删除的茶仓详情主键
     * @return 结果
     */
    @Override
    public int deleteTeaWarehouseDetailsByIds(Long[] ids)
    {
        return teaWarehouseDetailsMapper.deleteTeaWarehouseDetailsByIds(ids);
    }

    /**
     * 删除茶仓详情信息
     *
     * @param id 茶仓详情主键
     * @return 结果
     */
    @Override
    public int deleteTeaWarehouseDetailsById(Long id)
    {
        return teaWarehouseDetailsMapper.deleteTeaWarehouseDetailsById(id);
    }
}
