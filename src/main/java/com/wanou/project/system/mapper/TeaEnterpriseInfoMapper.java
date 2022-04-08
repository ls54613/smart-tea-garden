package com.wanou.project.system.mapper;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.wanou.project.system.domain.TeaEnterpriseInfo;
import com.wanou.project.system.domain.openApi.TeaEnterpriseTotal;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

/**
 * 茶企基本信息Mapper接口
 *
 * @author MrYao
 * @date 2022-03-01
 */
@Repository
public interface TeaEnterpriseInfoMapper
{
    /**
     * 查询茶企基本信息
     *
     * @param id 茶企基本信息主键
     * @return 茶企基本信息
     */
    public TeaEnterpriseInfo selectTeaEnterpriseInfoById(Long id,Long deptId);

    /**
     * 查询茶企基本信息列表
     *
     * @param teaEnterpriseInfo 茶企基本信息
     * @return 茶企基本信息集合
     */
    public List<TeaEnterpriseInfo> selectTeaEnterpriseInfoList(TeaEnterpriseInfo teaEnterpriseInfo);

    /**
     * 新增茶企基本信息
     *
     * @param teaEnterpriseInfo 茶企基本信息
     * @return 结果
     */
    public int insertTeaEnterpriseInfo(TeaEnterpriseInfo teaEnterpriseInfo);

    /**
     * 修改茶企基本信息
     *
     * @param teaEnterpriseInfo 茶企基本信息
     * @return 结果
     */
    public int updateTeaEnterpriseInfo(TeaEnterpriseInfo teaEnterpriseInfo);

    /**
     * 删除茶企基本信息
     *
     * @param id 茶企基本信息主键
     * @return 结果
     */
    public int deleteTeaEnterpriseInfoById(Long id);

    /**
     * 批量删除茶企基本信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaEnterpriseInfoByIds(Long[] ids);

    /**
     * 获取茶企统计数据
     * @return
     */
    TeaEnterpriseTotal getTotalData();

    List<JSONObject> getTeaSalesTypes(@Param("region") String region);

    List<JSONObject> getYieldGroupRegion();

    int selectTeaEnterpriseCount();

    Integer getEnterpriseCount(@Param("region") String region);

    List<JSONObject> getEnterpriseNameAndNumberMorney();

    JSONObject findTeaEnterpriseInfoById(Long id);
}
