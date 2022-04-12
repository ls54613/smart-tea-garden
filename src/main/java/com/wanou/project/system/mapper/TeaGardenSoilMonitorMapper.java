package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TeaGardenSoilMonitor;
import org.springframework.stereotype.Repository;

/**
 * 茶园土壤监测Mapper接口
 *
 * @author txh
 * @date 2022-03-17
 */
@Repository
public interface TeaGardenSoilMonitorMapper
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
     * 删除茶园土壤监测
     *
     * @param id 茶园土壤监测主键
     * @return 结果
     */
    public int deleteTeaGardenSoilMonitorById(Long id);

    /**
     * 批量删除茶园土壤监测
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaGardenSoilMonitorByIds(Long[] ids);

    void deleteTeaGardenTeaGardenSoilMonitorByTeaGardenId(Long[] teaGardenIds);
}
