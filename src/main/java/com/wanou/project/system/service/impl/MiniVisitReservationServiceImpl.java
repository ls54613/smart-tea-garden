package com.wanou.project.system.service.impl;

import com.wanou.project.applet.domain.MiniUser;
import com.wanou.project.system.domain.MiniVisitReservation;
import com.wanou.project.system.domain.TxPerson;
import com.wanou.project.system.mapper.MiniVisitReservationMapper;
import com.wanou.project.system.mapper.TxPersonMapper;
import com.wanou.project.system.service.ITxPersonService;
import com.wanou.project.system.service.MiniUserService;
import com.wanou.project.system.service.MiniVisitReservationService;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MiniVisitReservationServiceImpl implements MiniVisitReservationService {

    @Autowired
    private MiniVisitReservationMapper miniVisitReservationMapper;

    @Autowired
    private ITxPersonService txPersonService;
    @Autowired
    private TxPersonMapper txPersonMapper;
    @Autowired
    private MiniUserService miniUserService;

    @Override
    public List<MiniVisitReservation> selectMiniVisitReservationListByVisitDeptId(long deptId) {
        return miniVisitReservationMapper.selectMiniVisitReservationListByVisitDeptId( deptId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateMiniVisitReservation(MiniVisitReservation miniVisitReservation) {
        int count = miniVisitReservationMapper.updateMiniVisitReservation(miniVisitReservation);
        //如果审核通过 则同步到员工表
        if(miniVisitReservation.getStatus() == 2){
            //通过
            MiniUser miniUser = miniUserService.selectUserById(miniVisitReservation.getCreateUserId());
            TxPerson txPerson = new TxPerson();
            txPerson.setAddress("123"); //地址
            txPerson.setDepartmentId(miniVisitReservation.getVisitDeptId());
            txPerson.setDomainId(miniVisitReservation.getDomainId());
            txPerson.setEndTime(miniVisitReservation.getVisitDateEnd());
            txPerson.setImgBase64(miniUser.getPortrait());
            txPerson.setIdcardNum(miniUser.getIdCard());
            txPerson.setIdentityType(2); //访客
            txPerson.setLicenseImage(miniUser.getPortrait());
            txPerson.setMobile(miniUser.getPhone());
            txPerson.setName(miniUser.getMName());
            txPerson.setStartTime(miniVisitReservation.getVisitDateStart());
            txPersonService.insertTxPerson(txPerson);
        }
        return count;
    }

    @Override
    public List<MiniVisitReservation> selectMiniVisitReservationByUserId(Long userId) {
        return miniVisitReservationMapper.selectMiniVisitReservationByUserId(userId);
    }

    @Override
    public int insertMiniVisitReservation(MiniVisitReservation miniVisitReservation) {
        return miniVisitReservationMapper.insertMiniVisitReservation(miniVisitReservation);
    }

    @Override
    public TxPerson selectTxPersonByMobile(String mobile) {
        return txPersonMapper.selectTxPersonByMobile(mobile);
    }

    @Override
    public List<MiniVisitReservation> selectWaitAuditByMiniUserId(Long userId) {
        return miniVisitReservationMapper.selectWaitAuditByMiniUserId(userId);
    }
}
