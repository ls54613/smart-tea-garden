package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaGardenSoilMonitor;

/**
 * 茶园土壤监测Service接口
 * 
 * @author txh
 * @date 2022-03-17
 */
public interface ITeaGardenSoilMonitorService 
{
    /**
     * 查询茶园土壤监测
     * 
     * @param id 茶园土壤监测主键
     * @return 茶园土壤监测
     */
    public TeaGardenSoilMonitor selectTeaGardenSoilMonitorById(Long id);

    /**
     * 查询茶园土壤监测列表
     * 
     * @param teaGardenSoilMonitor 茶园土壤监测
     * @return 茶园土壤监测集合
     */
    public List<TeaGardenSoilMonitor> selectTeaGardenSoilMonitorList(TeaGardenSoilMonitor teaGardenSoilMonitor);

    /**
     * 新增茶园土壤监测
     * 
     * @param teaGardenSoilMonitor 茶园土壤监测
     * @return 结果
     */
    public int insertTeaGardenSoilMonitor(TeaGardenSoilMonitor teaGardenSoilMonitor);

    /**
     * 修改茶园土壤监测
     * 
     * @param teaGardenSoilMonitor 茶园土壤监测
     * @return 结果
     */
    public int updateTeaGardenSoilMonitor(TeaGardenSoilMonitor teaGardenSoilMonitor);

    /**
     * 批量删除茶园土壤监测
     * 
     * @param ids 需要删除的茶园土壤监测主键集合
     * @return 结果
     */
    public int deleteTeaGardenSoilMonitorByIds(Long[] ids);

    /**
     * 删除茶园土壤监测信息
     * 
     * @param id 茶园土壤监测主键
     * @return 结果
     */
    public int deleteTeaGardenSoilMonitorById(Long id);
}
