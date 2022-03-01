package com.wanou.project.system.controller;

import com.wanou.common.core.domain.AjaxResult;
import com.wanou.common.utils.ServletUtils;
import com.wanou.framework.security.service.TokenService;
import com.wanou.project.applet.domain.MiniUser;
import com.wanou.project.system.service.MiniUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/miniManage")
public class SysMiniUserController {
    @Autowired
    MiniUserService miniUserService;
    @Autowired
    TokenService service;

    //获取所有访客注册信息
    @GetMapping("/listInfo")
    public AjaxResult miniUserListInfo(){
        return AjaxResult.success(miniUserService.listMiniUserInfo());
    }

    //修改当前用户
    @PostMapping("/updateUser")
    public AjaxResult updateUser(@RequestBody MiniUser miniUser){
//        System.out.println("miniUser = " + miniUser);
        int i = miniUserService.updateMiniUser(miniUser);
        if (i>0){
            return AjaxResult.success("保存成功！");
        }else {
            return AjaxResult.error("保存失败！");
        }
//        return AjaxResult.success();
    }

    //删除当前用户
    @PostMapping("/deleteUser")
    public AjaxResult deleteUser(@RequestBody long id) {
        if (miniUserService.deleteMiniUserById(id) > 0) {
            return AjaxResult.success("删除成功!");
        } else {
            return AjaxResult.error("删除失败");
        }
    }


}
