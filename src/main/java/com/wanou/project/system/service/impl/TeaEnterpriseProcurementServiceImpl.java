package com.wanou.project.system.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.wanou.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TeaEnterpriseProcurementMapper;
import com.wanou.project.system.domain.TeaEnterpriseProcurement;
import com.wanou.project.system.service.ITeaEnterpriseProcurementService;

/**
 * 近半年采购情况Service业务层处理
 *
 * @author MrYao
 * @date 2022-03-03
 */
@Service
public class TeaEnterpriseProcurementServiceImpl implements ITeaEnterpriseProcurementService
{
    @Autowired
    private TeaEnterpriseProcurementMapper teaEnterpriseProcurementMapper;

    /**
     * 查询近半年采购情况
     *
     * @param id 近半年采购情况主键
     * @return 近半年采购情况
     */
    @Override
    public TeaEnterpriseProcurement selectTeaEnterpriseProcurementById(Long id)
    {
        return teaEnterpriseProcurementMapper.selectTeaEnterpriseProcurementById(id);
    }

    /**
     * 查询近半年采购情况列表
     *
     * @param teaEnterpriseProcurement 近半年采购情况
     * @return 近半年采购情况
     */
    @Override
    public List<TeaEnterpriseProcurement> selectTeaEnterpriseProcurementList(TeaEnterpriseProcurement teaEnterpriseProcurement)
    {
        if(teaEnterpriseProcurement.getDeptId() == null){
            teaEnterpriseProcurement.setDeptId(SecurityUtils.getDeptId());
        }
        return teaEnterpriseProcurementMapper.selectTeaEnterpriseProcurementList(teaEnterpriseProcurement);
    }

    /**
     * 新增近半年采购情况
     *
     * @param teaEnterpriseProcurement 近半年采购情况
     * @return 结果
     */
    @Override
    public int insertTeaEnterpriseProcurement(TeaEnterpriseProcurement teaEnterpriseProcurement)
    {
        return teaEnterpriseProcurementMapper.insertTeaEnterpriseProcurement(teaEnterpriseProcurement);
    }

    /**
     * 修改近半年采购情况
     *
     * @param teaEnterpriseProcurement 近半年采购情况
     * @return 结果
     */
    @Override
    public int updateTeaEnterpriseProcurement(TeaEnterpriseProcurement teaEnterpriseProcurement)
    {
        return teaEnterpriseProcurementMapper.updateTeaEnterpriseProcurement(teaEnterpriseProcurement);
    }

    /**
     * 批量删除近半年采购情况
     *
     * @param ids 需要删除的近半年采购情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaEnterpriseProcurementByIds(Long[] ids)
    {
        return teaEnterpriseProcurementMapper.deleteTeaEnterpriseProcurementByIds(ids);
    }

    /**
     * 删除近半年采购情况信息
     *
     * @param id 近半年采购情况主键
     * @return 结果
     */
    @Override
    public int deleteTeaEnterpriseProcurementById(Long id)
    {
        return teaEnterpriseProcurementMapper.deleteTeaEnterpriseProcurementById(id);
    }

    /**
     * 根据企业id查询采购动态
     * @param enterpriseId
     * @return
     */
    @Override
    public List<JSONObject> selectTeaEnterpriseProcurementByEnterpriseId(Long enterpriseId) {
        return teaEnterpriseProcurementMapper.selectTeaEnterpriseProcurementByEnterpriseId(enterpriseId);
    }
}
