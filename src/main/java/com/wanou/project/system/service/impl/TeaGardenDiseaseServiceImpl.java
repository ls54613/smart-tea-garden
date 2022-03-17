package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaGardenDiseaseMapper;
import com.wanou.project.system.domain.TeaGardenDisease;
import com.wanou.project.system.service.ITeaGardenDiseaseService;

/**
 * 病虫害分析Service业务层处理
 *
 * @author txh
 * @date 2022-03-17
 */
@Service
public class TeaGardenDiseaseServiceImpl implements ITeaGardenDiseaseService
{
    @Autowired
    private TeaGardenDiseaseMapper teaGardenDiseaseMapper;

    /**
     * 查询病虫害分析
     *
     * @param id 病虫害分析主键
     * @return 病虫害分析
     */
    @Override
    public TeaGardenDisease selectTeaGardenDiseaseById(Long id)
    {
        return teaGardenDiseaseMapper.selectTeaGardenDiseaseById(id);
    }

    /**
     * 查询病虫害分析列表
     *
     * @param teaGardenDisease 病虫害分析
     * @return 病虫害分析
     */
    @Override
    public List<TeaGardenDisease> selectTeaGardenDiseaseList(TeaGardenDisease teaGardenDisease)
    {
        return teaGardenDiseaseMapper.selectTeaGardenDiseaseList(teaGardenDisease);
    }

    /**
     * 新增病虫害分析
     *
     * @param teaGardenDisease 病虫害分析
     * @return 结果
     */
    @Override
    public int insertTeaGardenDisease(TeaGardenDisease teaGardenDisease)
    {
        return teaGardenDiseaseMapper.insertTeaGardenDisease(teaGardenDisease);
    }

    /**
     * 修改病虫害分析
     *
     * @param teaGardenDisease 病虫害分析
     * @return 结果
     */
    @Override
    public int updateTeaGardenDisease(TeaGardenDisease teaGardenDisease)
    {
        return teaGardenDiseaseMapper.updateTeaGardenDisease(teaGardenDisease);
    }

    /**
     * 批量删除病虫害分析
     *
     * @param ids 需要删除的病虫害分析主键
     * @return 结果
     */
    @Override
    public int deleteTeaGardenDiseaseByIds(Long[] ids)
    {
        return teaGardenDiseaseMapper.deleteTeaGardenDiseaseByIds(ids);
    }

    /**
     * 删除病虫害分析信息
     *
     * @param id 病虫害分析主键
     * @return 结果
     */
    @Override
    public int deleteTeaGardenDiseaseById(Long id)
    {
        return teaGardenDiseaseMapper.deleteTeaGardenDiseaseById(id);
    }
}
