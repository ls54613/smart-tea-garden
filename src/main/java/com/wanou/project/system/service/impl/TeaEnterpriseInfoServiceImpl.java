package com.wanou.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaEnterpriseInfoMapper;
import com.wanou.project.system.domain.TeaEnterpriseInfo;
import com.wanou.project.system.service.ITeaEnterpriseInfoService;

/**
 * 茶企基本信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-01
 */
@Service
public class TeaEnterpriseInfoServiceImpl implements ITeaEnterpriseInfoService
{
    @Autowired
    private TeaEnterpriseInfoMapper teaEnterpriseInfoMapper;

    /**
     * 查询茶企基本信息
     *
     * @param id 茶企基本信息主键
     * @return 茶企基本信息
     */
    @Override
    public TeaEnterpriseInfo selectTeaEnterpriseInfoById(Long id)
    {
        return teaEnterpriseInfoMapper.selectTeaEnterpriseInfoById(id);
    }

    /**
     * 查询茶企基本信息列表
     *
     * @param teaEnterpriseInfo 茶企基本信息
     * @return 茶企基本信息
     */
    @Override
    public List<TeaEnterpriseInfo> selectTeaEnterpriseInfoList(TeaEnterpriseInfo teaEnterpriseInfo)
    {
        return teaEnterpriseInfoMapper.selectTeaEnterpriseInfoList(teaEnterpriseInfo);
    }

    /**
     * 新增茶企基本信息
     *
     * @param teaEnterpriseInfo 茶企基本信息
     * @return 结果
     */
    @Override
    public int insertTeaEnterpriseInfo(TeaEnterpriseInfo teaEnterpriseInfo)
    {
        return teaEnterpriseInfoMapper.insertTeaEnterpriseInfo(teaEnterpriseInfo);
    }

    /**
     * 修改茶企基本信息
     *
     * @param teaEnterpriseInfo 茶企基本信息
     * @return 结果
     */
    @Override
    public int updateTeaEnterpriseInfo(TeaEnterpriseInfo teaEnterpriseInfo)
    {
        return teaEnterpriseInfoMapper.updateTeaEnterpriseInfo(teaEnterpriseInfo);
    }

    /**
     * 批量删除茶企基本信息
     *
     * @param ids 需要删除的茶企基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTeaEnterpriseInfoByIds(Long[] ids)
    {
        return teaEnterpriseInfoMapper.deleteTeaEnterpriseInfoByIds(ids);
    }

    /**
     * 删除茶企基本信息信息
     *
     * @param id 茶企基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTeaEnterpriseInfoById(Long id)
    {
        return teaEnterpriseInfoMapper.deleteTeaEnterpriseInfoById(id);
    }
}
