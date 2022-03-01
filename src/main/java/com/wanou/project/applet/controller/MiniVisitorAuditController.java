package com.wanou.project.applet.controller;

import cn.hutool.core.date.DateUtil;
import com.wanou.common.exception.MiniNoAccessException;
import com.wanou.common.exception.MiniUserNotFoundException;
import com.wanou.framework.redis.RedisCache;
import com.wanou.framework.security.mini.MiniContextUtils;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.project.applet.domain.MiniUser;
import com.wanou.project.system.domain.MiniVisitReservation;
import com.wanou.project.system.service.MiniUserService;
import com.wanou.project.system.service.MiniVisitReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author txh
 * @date 2021/8/31 16:14
 */
@RestController
@RequestMapping("/mini/visitorAudit")
public class MiniVisitorAuditController {
    @Autowired
    MiniVisitReservationService reservationService;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private MiniUserService miniUserService;

    /**
     * 查询当前用户权限下的等待审核的访客记录
     * @return
     */
    @GetMapping("/getWaitAuditList")
    public AjaxResult selectWaitAudit(){
        Long userId = MiniContextUtils.getUserId();
        List<MiniVisitReservation> visitReservations = reservationService.selectWaitAuditByMiniUserId(userId);

        return AjaxResult.success(visitReservations);
    }


    /**
     * 修改审核状态
     * @return
     */
    @PostMapping("/updateAuditStatus")
    public AjaxResult updateAuditStatus(@RequestBody MiniVisitReservation miniVisitReservation){
        if(miniVisitReservation == null){
            return AjaxResult.error("参数异常");
        }
        Long userId = MiniContextUtils.getUserId();
        MiniUser miniUser = miniUserService.selectUserById(userId);
        if(miniUser == null){
            throw new MiniUserNotFoundException();
        }
        if(miniUser.getIsAuditor() == null || miniUser.getIsAuditor() != 1){
            throw new MiniNoAccessException();
        }
        //todo 被访问人是同一个人的时候多条只显示一条bug
        miniVisitReservation.setAuditorId(miniUser.getId());
        miniVisitReservation.setAuditTime(DateUtil.date());
        reservationService.updateMiniVisitReservation(miniVisitReservation);
        return AjaxResult.success("成功");
    }
}
