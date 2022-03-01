package com.wanou.project.system.mapper;

import com.wanou.project.system.domain.TxPerson;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 员工管理Mapper接口
 *
 * @author wanou
 * @date 2021-08-11
 */
@Repository
public interface TxPersonMapper
{
    /**
     * 查询员工管理
     *
     * @param staffid 员工管理主键
     * @return 员工管理
     */
    public TxPerson selectTxPersonByStaffid(Long staffid);


    /**
     * Description: 根据姓名查询
     * @param username: 姓名
     * @return: 员工
     */
    public TxPerson selectTxPersonByName(String username);


    /**
     * Description: 根据身份证查询
     * @param idcardNum: 身份证
     * @return: 员工
     */
    public TxPerson selectTxPersonByIdCardNum(String idcardNum);


    /**
     * Description: 根据手机号查询人员
     * @param mobile: 手机号
     * @return:
     * @date: 2021/8/20 12:11
     */
    TxPerson selectTxPersonByMobile(String mobile);

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
     * 修改员工管理
     *
     * @param txPerson 员工管理
     * @return 结果
     */
    public int updateTxPerson(TxPerson txPerson);

    /**
     * 删除员工管理
     *
     * @param staffid 员工管理主键
     * @return 结果
     */
    public int deleteTxPersonByStaffid(Long staffid);

    /**
     * 批量删除员工管理
     *
     * @param staffids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTxPersonByStaffids(Long[] staffids);

    /**
     * 删除人员时向人员日志表插入一条数据
     *
     * @param txPerson 删除人员的信息
     * @return 结果
     */
    public int insertTxPersonLog(TxPerson txPerson);


    /**
     * 根据身份证号查询
     * @param idCard
     * @return
     */
    TxPerson selectPersonByIdCard(String idCard);
}
