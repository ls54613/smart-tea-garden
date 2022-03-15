package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaGardenTeaType;

/**
 * 茶园种植种类占比Service接口
 * 
 * @author ruoyi
 * @date 2022-03-14
 */
public interface ITeaGardenTeaTypeService 
{
    /**
     * 查询茶园种植种类占比
     * 
     * @param id 茶园种植种类占比主键
     * @return 茶园种植种类占比
     */
    public TeaGardenTeaType selectTeaGardenTeaTypeById(Long id);

    /**
     * 查询茶园种植种类占比列表
     * 
     * @param teaGardenTeaType 茶园种植种类占比
     * @return 茶园种植种类占比集合
     */
    public List<TeaGardenTeaType> selectTeaGardenTeaTypeList(TeaGardenTeaType teaGardenTeaType);

    /**
     * 新增茶园种植种类占比
     * 
     * @param teaGardenTeaType 茶园种植种类占比
     * @return 结果
     */
    public int insertTeaGardenTeaType(TeaGardenTeaType teaGardenTeaType);

    /**
     * 修改茶园种植种类占比
     * 
     * @param teaGardenTeaType 茶园种植种类占比
     * @return 结果
     */
    public int updateTeaGardenTeaType(TeaGardenTeaType teaGardenTeaType);

    /**
     * 批量删除茶园种植种类占比
     * 
     * @param ids 需要删除的茶园种植种类占比主键集合
     * @return 结果
     */
    public int deleteTeaGardenTeaTypeByIds(Long[] ids);

    /**
     * 删除茶园种植种类占比信息
     * 
     * @param id 茶园种植种类占比主键
     * @return 结果
     */
    public int deleteTeaGardenTeaTypeById(Long id);
}
