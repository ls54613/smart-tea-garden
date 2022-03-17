package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaGardenDisease;

/**
 * 病虫害分析Service接口
 * 
 * @author txh
 * @date 2022-03-17
 */
public interface ITeaGardenDiseaseService 
{
    /**
     * 查询病虫害分析
     * 
     * @param id 病虫害分析主键
     * @return 病虫害分析
     */
    public TeaGardenDisease selectTeaGardenDiseaseById(Long id);

    /**
     * 查询病虫害分析列表
     * 
     * @param teaGardenDisease 病虫害分析
     * @return 病虫害分析集合
     */
    public List<TeaGardenDisease> selectTeaGardenDiseaseList(TeaGardenDisease teaGardenDisease);

    /**
     * 新增病虫害分析
     * 
     * @param teaGardenDisease 病虫害分析
     * @return 结果
     */
    public int insertTeaGardenDisease(TeaGardenDisease teaGardenDisease);

    /**
     * 修改病虫害分析
     * 
     * @param teaGardenDisease 病虫害分析
     * @return 结果
     */
    public int updateTeaGardenDisease(TeaGardenDisease teaGardenDisease);

    /**
     * 批量删除病虫害分析
     * 
     * @param ids 需要删除的病虫害分析主键集合
     * @return 结果
     */
    public int deleteTeaGardenDiseaseByIds(Long[] ids);

    /**
     * 删除病虫害分析信息
     * 
     * @param id 病虫害分析主键
     * @return 结果
     */
    public int deleteTeaGardenDiseaseById(Long id);
}
