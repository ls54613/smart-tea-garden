package com.wanou.project.applet.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.wanou.common.constant.Constants;
import com.wanou.framework.redis.RedisCache;
import com.wanou.framework.security.mini.MiniContextUtils;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.project.system.domain.MiniVisitReservation;
import com.wanou.project.system.domain.SysDept;
import com.wanou.project.system.service.ISysDeptService;
import com.wanou.project.system.service.MiniVisitReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController("AppletMiniVisitReservationController")
@RequestMapping("/mini")
public class MiniVisitReservationController {
    @Autowired
    MiniVisitReservationService reservationService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private RedisCache redisCache;


    /**
     * Description: 查询个人预约记录
     * @return:
     * @date: 2021/8/20 10:53
     */
    @GetMapping("/selectMiniVisitReservationByUserId")
    public AjaxResult selectMiniVisitReservationByUserId() {
        Long userId = MiniContextUtils.getUserId();
        return AjaxResult.success(reservationService.selectMiniVisitReservationByUserId(userId));
    }



    /**
     * Description: 增加预约
     * @param miniVisitReservation: 预约信息
     * @return:
     * @date: 2021/8/20 10:55
     */
    @PostMapping("/insertMiniVisitReservation")
    public AjaxResult insertMiniVisitReservation(@RequestBody MiniVisitReservation miniVisitReservation){
        DateTime nowDate = DateUtil.date();
        if(miniVisitReservation.getVisitDateEnd().getTime() <= nowDate.getTime()){
            return AjaxResult.error("结束时间不能早于现在时间");
        }
        Long userId = MiniContextUtils.getUserId();
        /*List<MiniVisitReservation> miniVisitReservationList = reservationService.selectReservationByUserIdAndIntervieweeId(userId,miniVisitReservation.getIntervieweeId());
        //查询是否已经预约
        for (MiniVisitReservation visitReservation : miniVisitReservationList) {
            if(visitReservation.getVisitDateEnd()){

            }
        }*/

        miniVisitReservation.setCreateUserId(userId);
        miniVisitReservation.setCreateTime(new Date(System.currentTimeMillis()));
        if (reservationService.insertMiniVisitReservation(miniVisitReservation) >= 1)
            return AjaxResult.success("成功");
        return AjaxResult.error("失败");
    }



    /**
     * 查询部门管理数据
     *
     * @return 部门信息集合
     */
    @GetMapping("/selectDeptByDept")
    public AjaxResult selectDeptByDept(){
//        List<SysDept> cacheListBoundAll = redisCache.rightGetCacheBoundListAll(Constants.DEPT_LIST);
        List<SysDept> cacheListBoundAll = redisCache.getCacheList(Constants.DEPT_LIST);
        if (cacheListBoundAll == null || cacheListBoundAll.size() < 1){
            cacheListBoundAll = deptService.selectDeptList(new SysDept());
            Iterator<SysDept> it = cacheListBoundAll.iterator();
         /*   while (it.hasNext())
            {
                SysDept d = (SysDept) it.next();
                if (d.getDeptId().intValue() == 100)
                {
                    it.remove();
                }
            }*/
        /*    for (SysDept dept : depts) {
                       redisCache.leftSetCacheBoundList(Constants.DEPT_LIST,dept);
            }*/
            redisCache.setCacheList(Constants.DEPT_LIST,cacheListBoundAll);
            //redisCache.setCacheListBound(Constants.DEPT_LIST,depts);
        }
        return AjaxResult.success(deptService.buildDeptTreeSelect(cacheListBoundAll));
    }


    /**
     * Description: 根据手机号查询人员
     * @param mobile: 手机号
     * @return:
     * @date: 2021/8/20 12:11
     */
    @GetMapping("/selectTxPersonByMobile/{mobile}")
    public AjaxResult selectTxPersonByMobile(@PathVariable("mobile") String mobile){
        return AjaxResult.success(reservationService.selectTxPersonByMobile(mobile));
    }


}
