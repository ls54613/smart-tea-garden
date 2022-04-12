package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TeaGardenDisease;
import org.springframework.stereotype.Repository;

/**
 * 病虫害分析Mapper接口
 *
 * @author txh
 * @date 2022-03-17
 */
@Repository
public interface TeaGardenDiseaseMapper
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
     * 删除病虫害分析
     *
     * @param id 病虫害分析主键
     * @return 结果
     */
    public int deleteTeaGardenDiseaseById(Long id);

    /**
     * 批量删除病虫害分析
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaGardenDiseaseByIds(Long[] ids);

    void deleteTeaGardenDiseaseByTeaGardenId(Long[] teaGardenIds);
}
