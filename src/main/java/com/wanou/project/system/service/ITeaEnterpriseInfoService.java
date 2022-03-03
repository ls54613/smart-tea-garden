package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaEnterpriseInfo;

/**
 * 茶企基本信息Service接口
 *
 * @author MrYao
 * @date 2022-03-01
 */
public interface ITeaEnterpriseInfoService
{
    /**
     * 查询茶企基本信息
     *
     * @param id 茶企基本信息主键
     * @return 茶企基本信息
     */
    public TeaEnterpriseInfo selectTeaEnterpriseInfoById(Long id);

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
     * 批量删除茶企基本信息
     *
     * @param ids 需要删除的茶企基本信息主键集合
     * @return 结果
     */
    public int deleteTeaEnterpriseInfoByIds(Long[] ids);

    /**
     * 删除茶企基本信息信息
     *
     * @param id 茶企基本信息主键
     * @return 结果
     */
    public int deleteTeaEnterpriseInfoById(Long id);
}
