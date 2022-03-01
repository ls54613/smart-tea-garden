package com.wanou.project.applet.controller;

import cn.hutool.core.util.StrUtil;
import com.wanou.framework.security.mini.MiniContextUtils;
import com.wanou.project.applet.domain.MiniUser;
import com.wanou.project.applet.service.MiniLoginService;
import com.wanou.common.core.domain.AjaxResult;
import com.wanou.project.applet.domain.dto.LoginDto;
import com.wanou.project.applet.domain.dto.MiniUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author txh
 * @date 2021/8/20 14:58
 */
@RestController
@RequestMapping("/mini")
public class MiniLoginController {
    @Autowired
    private MiniLoginService miniLoginService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginDto loginDto){
        if(loginDto == null){
            return AjaxResult.error("参数异常");
        }
        MiniUserDto miniUserDto = miniLoginService.weChatLogin(loginDto.getCode());

        return AjaxResult.success(miniUserDto);
    }

    /**
     * 注册用户
     *
     * @param registerUser 注册信息
     * @return 注册后信息
     */
    @PostMapping("/register")
    public AjaxResult register(@RequestBody MiniUser registerUser) {
        if(registerUser == null || StrUtil.isBlank(registerUser.getMName())
        || StrUtil.isBlank(registerUser.getPhone()) || StrUtil.isBlank(registerUser.getIdCard()) || StrUtil.isBlank(registerUser.getPortrait())){
            return AjaxResult.error("参数错误");
        }
        String openId = MiniContextUtils.getOpenId();
        registerUser.setOpenId(openId);
        MiniUserDto miniUserDto = miniLoginService.weChatRegister(registerUser);
        if(miniUserDto == null){
            return AjaxResult.error("注册失败,请重新进入小程序后重试");
        }
        return AjaxResult.success(miniUserDto);
    }
}
