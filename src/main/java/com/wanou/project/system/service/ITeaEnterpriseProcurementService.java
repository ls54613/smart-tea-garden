package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TeaEnterpriseProcurement;

/**
 * 近半年采购情况Service接口
 * 
 * @author MrYao
 * @date 2022-03-03
 */
public interface ITeaEnterpriseProcurementService 
{
    /**
     * 查询近半年采购情况
     * 
     * @param id 近半年采购情况主键
     * @return 近半年采购情况
     */
    public TeaEnterpriseProcurement selectTeaEnterpriseProcurementById(Long id);

    /**
     * 查询近半年采购情况列表
     * 
     * @param teaEnterpriseProcurement 近半年采购情况
     * @return 近半年采购情况集合
     */
    public List<TeaEnterpriseProcurement> selectTeaEnterpriseProcurementList(TeaEnterpriseProcurement teaEnterpriseProcurement);

    /**
     * 新增近半年采购情况
     * 
     * @param teaEnterpriseProcurement 近半年采购情况
     * @return 结果
     */
    public int insertTeaEnterpriseProcurement(TeaEnterpriseProcurement teaEnterpriseProcurement);

    /**
     * 修改近半年采购情况
     * 
     * @param teaEnterpriseProcurement 近半年采购情况
     * @return 结果
     */
    public int updateTeaEnterpriseProcurement(TeaEnterpriseProcurement teaEnterpriseProcurement);

    /**
     * 批量删除近半年采购情况
     * 
     * @param ids 需要删除的近半年采购情况主键集合
     * @return 结果
     */
    public int deleteTeaEnterpriseProcurementByIds(Long[] ids);

    /**
     * 删除近半年采购情况信息
     * 
     * @param id 近半年采购情况主键
     * @return 结果
     */
    public int deleteTeaEnterpriseProcurementById(Long id);
}
