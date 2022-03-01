package com.wanou.project.system.service;

import com.wanou.project.system.domain.TxPerson;

import java.util.List;

/**
 * 员工管理Service接口
 *
 * @author wanou
 * @date 2021-08-11
 */
public interface ITxPersonService
{
    /**
     * 查询员工管理
     *
     * @param staffid 员工管理主键
     * @return 员工管理
     */
    public TxPerson selectTxPersonByStaffid(Long staffid);

    /**
     * 查询员工管理列表
     *
     * @param txPerson 员工管理
     * @return 员工管理集合
     */
    public List<TxPerson> selectTxPersonList(TxPerson txPerson);

    /**
     * 新增员工管理
     *
     * @param txPerson 员工管理
     * @return 结果
     */
    public int insertTxPerson(TxPerson txPerson);

    /**
     * 新增员工excel导入
     * @param txPerson
     * @return
     */
    public int insertTxPersonExcelImport(TxPerson txPerson);

    /**
     * 修改员工管理
     *
     * @param txPerson 员工管理
     * @return 结果
     */
    public int updateTxPerson(TxPerson txPerson);

    /**
     * excel导入更新人员
     * @param txPerson
     * @return
     */
    public int updateTxPersonExcelImport(TxPerson txPerson);

    /**
     * 批量删除员工管理
     *
     * @param staffids 需要删除的员工管理主键集合
     * @return 结果
     */
    public int deleteTxPersonByStaffids(Long[] staffids);

    /**
     * 删除员工管理信息
     *
     * @param staffid 员工管理主键
     * @return 结果
     */
    public int deleteTxPersonByStaffid(Long staffid);

    /**
     * 导入用户数据
     *
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importTxPerson(List<TxPerson> userList, Boolean isUpdateSupport, String operName);
    

    /**
     * 根据身份证号码查询
     * @param idCard
     * @return
     */
    TxPerson selectPersonByIdCard(String idCard);

    /**
     * 生成人员与小程序用户绑定二维码
     * @return
     */
    String generatePersonBindQrCode(Long personId);
}
