package com.wanou.project.system.service;

import com.wanou.project.system.domain.MiniVisitReservation;
import com.wanou.project.system.domain.TxPerson;

import java.util.List;

public interface MiniVisitReservationService {
    //获取信息列表
    List<MiniVisitReservation> selectMiniVisitReservationListByVisitDeptId(long visitDeptId);

    //修改用户信息
    int updateMiniVisitReservation(MiniVisitReservation miniVisitReservation);





    /**
     *
     *
     *
     *
     *
     *
     * 小程序端接口
     *
     *
     *
     *
     *
     *
     *
     * */

    /**
     * Description: 查询个人预约记录
     * @param userId: userId
     * @return:
     * @date: 2021/8/20 10:53
     */
    List<MiniVisitReservation> selectMiniVisitReservationByUserId(Long userId);



    /**
     * Description: 增加预约
     * @param miniVisitReservation: 预约信息
     * @return:
     * @date: 2021/8/20 10:55
     */
    int insertMiniVisitReservation(MiniVisitReservation miniVisitReservation);


    /**
     * Description: 根据手机号查询人员
     * @param mobile: 手机号
     * @return:
     * @date: 2021/8/20 12:11
     */
    TxPerson selectTxPersonByMobile(String mobile);


    /**
     * 查询当前小程序用户权限下的等待审核的访客记录
     * @param userId
     * @return
     */
    List<MiniVisitReservation> selectWaitAuditByMiniUserId(Long userId);
}
