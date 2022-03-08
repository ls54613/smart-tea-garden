package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TeaEnterpriseTeaType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 茶企茶叶种类Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-05
 */
@Repository
public interface TeaEnterpriseTeaTypeMapper
{
    /**
     * 查询茶企茶叶种类
     *
     * @param id 茶企茶叶种类主键
     * @return 茶企茶叶种类
     */
    public TeaEnterpriseTeaType selectTeaEnterpriseTeaTypeById(Long id);

    /**
     * 查询茶企茶叶种类列表
     *
     * @param teaEnterpriseTeaType 茶企茶叶种类
     * @return 茶企茶叶种类集合
     */
    public List<TeaEnterpriseTeaType> selectTeaEnterpriseTeaTypeList(TeaEnterpriseTeaType teaEnterpriseTeaType);

    /**
     * 新增茶企茶叶种类
     *
     * @param teaEnterpriseTeaType 茶企茶叶种类
     * @return 结果
     */
    public int insertTeaEnterpriseTeaType(TeaEnterpriseTeaType teaEnterpriseTeaType);

    /**
     * 修改茶企茶叶种类
     *
     * @param teaEnterpriseTeaType 茶企茶叶种类
     * @return 结果
     */
    public int updateTeaEnterpriseTeaType(TeaEnterpriseTeaType teaEnterpriseTeaType);

    /**
     * 删除茶企茶叶种类
     *
     * @param id 茶企茶叶种类主键
     * @return 结果
     */
    public int deleteTeaEnterpriseTeaTypeById(Long id);


    public List<TeaEnterpriseTeaType> selectTeaEnterpriseByListId(List<Integer> id);

    /**
     * 批量删除茶企茶叶种类
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaEnterpriseTeaTypeByIds(Long[] ids);

    public void batchInsert(@Param("teaEnterpriseTeaTypeList") List<TeaEnterpriseTeaType> teaEnterpriseTeaTypeList);

    public void  deleteTeaEnterpriseTeaTypeByTeaEnterpriseId(long id);


    public List<TeaEnterpriseTeaType> selectTeaEnterpriseTeaTypeListByTeaEnterpriseId(long id);
    public List<Integer> selectTeaEnterpriseTeaTypeIntListByTeaEnterpriseId(long id);

    void deleteTeaEnterpriseTeaTypeByTeaEnterpriseIds(Long[] ids);
}
