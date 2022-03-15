package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaGardenTeaTypeMapper;
import com.wanou.project.system.domain.TeaGardenTeaType;
import com.wanou.project.system.service.ITeaGardenTeaTypeService;

/**
 * 茶园种植种类占比Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-14
 */
@Service
public class TeaGardenTeaTypeServiceImpl implements ITeaGardenTeaTypeService
{
    @Autowired
    private TeaGardenTeaTypeMapper teaGardenTeaTypeMapper;

    /**
     * 查询茶园种植种类占比
     *
     * @param id 茶园种植种类占比主键
     * @return 茶园种植种类占比
     */
    @Override
    public TeaGardenTeaType selectTeaGardenTeaTypeById(Long id)
    {
        return teaGardenTeaTypeMapper.selectTeaGardenTeaTypeById(id);
    }

    /**
     * 查询茶园种植种类占比列表
     *
     * @param teaGardenTeaType 茶园种植种类占比
     * @return 茶园种植种类占比
     */
    @Override
    public List<TeaGardenTeaType> selectTeaGardenTeaTypeList(TeaGardenTeaType teaGardenTeaType)
    {
        return teaGardenTeaTypeMapper.selectTeaGardenTeaTypeList(teaGardenTeaType);
    }

    /**
     * 新增茶园种植种类占比
     *
     * @param teaGardenTeaType 茶园种植种类占比
     * @return 结果
     */
    @Override
    public int insertTeaGardenTeaType(TeaGardenTeaType teaGardenTeaType)
    {
        return teaGardenTeaTypeMapper.insertTeaGardenTeaType(teaGardenTeaType);
    }

    /**
     * 修改茶园种植种类占比
     *
     * @param teaGardenTeaType 茶园种植种类占比
     * @return 结果
     */
    @Override
    public int updateTeaGardenTeaType(TeaGardenTeaType teaGardenTeaType)
    {
        return teaGardenTeaTypeMapper.updateTeaGardenTeaType(teaGardenTeaType);
    }

    /**
     * 批量删除茶园种植种类占比
     *
     * @param ids 需要删除的茶园种植种类占比主键
     * @return 结果
     */
    @Override
    public int deleteTeaGardenTeaTypeByIds(Long[] ids)
    {
        return teaGardenTeaTypeMapper.deleteTeaGardenTeaTypeByIds(ids);
    }

    /**
     * 删除茶园种植种类占比信息
     *
     * @param id 茶园种植种类占比主键
     * @return 结果
     */
    @Override
    public int deleteTeaGardenTeaTypeById(Long id)
    {
        return teaGardenTeaTypeMapper.deleteTeaGardenTeaTypeById(id);
    }
}
