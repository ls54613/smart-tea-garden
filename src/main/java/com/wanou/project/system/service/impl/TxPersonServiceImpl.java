package com.wanou.project.system.service.impl;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.wanou.common.constant.Constants;
import com.wanou.common.exception.CustomException;
import com.wanou.common.utils.IdUtils;
import com.wanou.common.utils.StringUtils;
import com.wanou.framework.aspectj.lang.annotation.DataScope;
import com.wanou.framework.redis.RedisCache;
import com.wanou.framework.security.service.TokenService;
import com.wanou.project.system.domain.TxPerson;
import com.wanou.project.system.mapper.TxPersonMapper;
import com.wanou.project.system.service.ITxPersonService;
import com.wanou.project.system.service.MiniUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 员工管理Service业务层处理
 *
 * @author wanou
 * @date 2021-08-11
 */
@Service
public class TxPersonServiceImpl implements ITxPersonService
{
    @Autowired
    private TxPersonMapper txPersonMapper;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private MiniUserService miniUserService;

    /**
     * 查询员工管理
     *
     * @param staffid 员工管理主键
     * @return 员工管理
     */
    @Override
    public TxPerson selectTxPersonByStaffid(Long staffid)
    {
        return txPersonMapper.selectTxPersonByStaffid(staffid);
    }

    /**
     * 查询员工管理列表
     *
     * @param txPerson 员工管理
     * @return 员工管理
     */
    @Override
    @DataScope(deptAlias = "d",txPersonAlias = "txp")
    public List<TxPerson> selectTxPersonList(TxPerson txPerson)
    {
        return txPersonMapper.selectTxPersonList(txPerson);
    }

    /**
     * 新增员工管理
     *
     * @param txPerson 员工管理
     * @return 结果
     */
    @Override
    public int insertTxPerson(TxPerson txPerson)
    {
        int count = txPersonMapper.insertTxPerson(txPerson);
        return count;
    }

    /**
     * 新增员工excel导入
     * @param txPerson
     * @return
     */
    @Override
    public int insertTxPersonExcelImport(TxPerson txPerson) {
        return txPersonMapper.insertTxPerson(txPerson);
    }

    /**
     * 修改员工管理
     *
     * @param txPerson 员工管理
     * @return 结果
     */
    @Override
    public int updateTxPerson(TxPerson txPerson)
    {
        int count = txPersonMapper.updateTxPerson(txPerson);
        return count;
    }

    /**
     * 批量删除员工管理
     *
     * @param staffids 需要删除的员工管理主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteTxPersonByStaffids(Long[] staffids)
    {

        for (Long staffid : staffids) {
            TxPerson txPerson = txPersonMapper.selectTxPersonByStaffid(staffid);
            txPersonMapper.insertTxPersonLog(txPerson);
        }
        int count = txPersonMapper.deleteTxPersonByStaffids(staffids);
        return count;
    }

    /**
     * 删除员工管理信息
     *
     * @param staffid 员工管理主键  已作废
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteTxPersonByStaffid(Long staffid)
    {
        TxPerson txPerson = txPersonMapper.selectTxPersonByStaffid(staffid);
        txPersonMapper.insertTxPersonLog(txPerson);
        return txPersonMapper.deleteTxPersonByStaffid(staffid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importTxPerson(List<TxPerson> txPersonList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(txPersonList) || txPersonList.size() == 0)
        {
            throw new CustomException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        //List<TxPersonExcelImportResultVO> importResult = new ArrayList<>();
        for (TxPerson txPerson : txPersonList)
        {
            try
            {
                // 验证是否存在这个用户
                TxPerson u = txPersonMapper.selectTxPersonByIdCardNum(txPerson.getIdcardNum());
                if (StringUtils.isNull(u))
                {
                    txPerson.setPType(19);
                    this.insertTxPersonExcelImport(txPerson);
                    //添加人员操作任务
                    //personTaskService.addEditUserTask(txPerson);

                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + txPerson.getName() + " 导入成功");
                    /*TxPersonExcelImportResultVO txPersonExcelImportResultVO = new TxPersonExcelImportResultVO();
                    txPersonExcelImportResultVO.setPersonName(txPerson.getName());
                    txPersonExcelImportResultVO.setStatus(1);
                    txPersonExcelImportResultVO.setStatusMessage("导入成功");
                    importResult.add(txPersonExcelImportResultVO);*/

                }
                else if (isUpdateSupport)
                {
                    txPerson.setUpdateBy(operName);
                    txPerson.setStaffid(u.getStaffid());
                    this.updateTxPersonExcelImport(txPerson);
                    //添加人员操作任务
                    //personTaskService.addEditUserTask(txPerson);

                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + txPerson.getName() + " 更新成功");
                    /*TxPersonExcelImportResultVO txPersonExcelImportResultVO = new TxPersonExcelImportResultVO();
                    txPersonExcelImportResultVO.setPersonName(txPerson.getName());
                    txPersonExcelImportResultVO.setStatus(1);
                    txPersonExcelImportResultVO.setStatusMessage("更新成功");
                    importResult.add(txPersonExcelImportResultVO);*/

                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + txPerson.getName() + " 已存在");
                    /*TxPersonExcelImportResultVO txPersonExcelImportResultVO = new TxPersonExcelImportResultVO();
                    txPersonExcelImportResultVO.setPersonName(txPerson.getName());
                    txPersonExcelImportResultVO.setStatus(0);
                    txPersonExcelImportResultVO.setStatusMessage("已存在");
                    importResult.add(txPersonExcelImportResultVO);*/
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + txPerson.getName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                /*TxPersonExcelImportResultVO txPersonExcelImportResultVO = new TxPersonExcelImportResultVO();
                txPersonExcelImportResultVO.setPersonName(txPerson.getName());
                txPersonExcelImportResultVO.setStatus(0);
                txPersonExcelImportResultVO.setStatusMessage("导入失败:" + e.getMessage());
                importResult.add(txPersonExcelImportResultVO);*/
//                log.error(msg, e);
            }
        }


        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }


    /**
     * 根据身份证号查询
     * @param idCard
     * @return
     */
    @Override
    public TxPerson selectPersonByIdCard(String idCard) {
        return txPersonMapper.selectPersonByIdCard(idCard);
    }

    /**
     * 生成人员与小程序用户绑定二维码
     * @return
     */
    @Override
    public String generatePersonBindQrCode(Long personId) {
        //生成唯一id
        String uuid = IdUtils.fastSimpleUUID();
        //存储在redis中 24小时过期
        redisCache.setObjectBoundExpire(Constants.PERSON_BIND_CODE + uuid,personId,60*60*24); //24小时过期
        QrConfig qrConfig = QrConfig.create();
        qrConfig.setWidth(300);
        qrConfig.setHeight(300);
        String base64 = QrCodeUtil.generateAsBase64("personBind_" + uuid, qrConfig, ImgUtil.IMAGE_TYPE_PNG);
        return base64;
    }

    /**
     * excel更新人员
     * @return
     */
    @Override
    public int updateTxPersonExcelImport(TxPerson txPerson) {
        return txPersonMapper.updateTxPerson(txPerson);
    }
}
