package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaGardenSoilMonitorMapper;
import com.wanou.project.system.domain.TeaGardenSoilMonitor;
import com.wanou.project.system.service.ITeaGardenSoilMonitorService;

/**
 * 茶园土壤监测Service业务层处理
 *
 * @author txh
 * @date 2022-03-17
 */
@Service
public class TeaGardenSoilMonitorServiceImpl implements ITeaGardenSoilMonitorService
{
    @Autowired
    private TeaGardenSoilMonitorMapper teaGardenSoilMonitorMapper;

    /**
     * 查询茶园土壤监测
     *
     * @param id 茶园土壤监测主键
     * @return 茶园土壤监测
     */
    @Override
    public TeaGardenSoilMonitor selectTeaGardenSoilMonitorById(Long id)
    {
        return teaGardenSoilMonitorMapper.selectTeaGardenSoilMonitorById(id);
    }

    /**
     * 查询茶园土壤监测列表
     *
     * @param teaGardenSoilMonitor 茶园土壤监测
     * @return 茶园土壤监测
     */
    @Override
    public List<TeaGardenSoilMonitor> selectTeaGardenSoilMonitorList(TeaGardenSoilMonitor teaGardenSoilMonitor)
    {
        return teaGardenSoilMonitorMapper.selectTeaGardenSoilMonitorList(teaGardenSoilMonitor);
    }

    /**
     * 新增茶园土壤监测
     *
     * @param teaGardenSoilMonitor 茶园土壤监测
     * @return 结果
     */
    @Override
    public int insertTeaGardenSoilMonitor(TeaGardenSoilMonitor teaGardenSoilMonitor)
    {
        return teaGardenSoilMonitorMapper.insertTeaGardenSoilMonitor(teaGardenSoilMonitor);
    }

    /**
     * 修改茶园土壤监测
     *
     * @param teaGardenSoilMonitor 茶园土壤监测
     * @return 结果
     */
    @Override
    public int updateTeaGardenSoilMonitor(TeaGardenSoilMonitor teaGardenSoilMonitor)
    {
        return teaGardenSoilMonitorMapper.updateTeaGardenSoilMonitor(teaGardenSoilMonitor);
    }

    /**
     * 批量删除茶园土壤监测
     *
     * @param ids 需要删除的茶园土壤监测主键
     * @return 结果
     */
    @Override
    public int deleteTeaGardenSoilMonitorByIds(Long[] ids)
    {
        return teaGardenSoilMonitorMapper.deleteTeaGardenSoilMonitorByIds(ids);
    }

    /**
     * 删除茶园土壤监测信息
     *
     * @param id 茶园土壤监测主键
     * @return 结果
     */
    @Override
    public int deleteTeaGardenSoilMonitorById(Long id)
    {
        return teaGardenSoilMonitorMapper.deleteTeaGardenSoilMonitorById(id);
    }
}
