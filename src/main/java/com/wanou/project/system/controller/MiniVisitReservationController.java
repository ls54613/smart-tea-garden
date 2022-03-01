package com.wanou.project.system.controller;

import com.wanou.common.core.domain.AjaxResult;
import com.wanou.common.utils.ServletUtils;
import com.wanou.framework.security.service.TokenService;
import com.wanou.project.system.domain.MiniVisitReservation;
import com.wanou.project.system.service.MiniVisitReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/miniNote")
public class MiniVisitReservationController {
    @Autowired
    MiniVisitReservationService reservationService;

    @Autowired
    TokenService service;

    @GetMapping("/getList")
    public AjaxResult getList(){
        Long deptId = service.getLoginUser(ServletUtils.getRequest()).getUser().getDeptId();
        return AjaxResult.success(reservationService.selectMiniVisitReservationListByVisitDeptId(deptId));
    }

    @PostMapping("/updateNotes")
    public AjaxResult updateNotes(@RequestBody MiniVisitReservation miniVisitReservation){
        if (reservationService.updateMiniVisitReservation(miniVisitReservation)>0) {
            return AjaxResult.success("修改成功！");
        }else {
            return AjaxResult.error("修改失败！");
        }
    }

}
