package com.wanou.project.applet.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.wanou.common.constant.Constants;
import com.wanou.common.core.domain.AjaxResult;
import com.wanou.common.exception.MiniUserNotFoundException;
import com.wanou.common.exception.NoBindMiniUserException;
import com.wanou.framework.redis.RedisCache;
import com.wanou.framework.security.mini.MiniContextUtils;
import com.wanou.project.applet.domain.MiniUser;
import com.wanou.project.applet.domain.dto.MiniUserDto;
import com.wanou.project.system.domain.TxPerson;
import com.wanou.project.system.service.MiniUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController("AppletMiniUserController")
@RequestMapping("/mini")
public class MiniUserController {
    @Autowired
    MiniUserService miniUserService;
    @Autowired
    private RedisCache redisCache;


    //查询当前用户的信息
    @ApiOperation("根据当前用户微信openId查询")
    @GetMapping("/selectUserByOpenId")
    public AjaxResult selectUserByOpenId(){
        String openId = MiniContextUtils.getOpenId();
        MiniUser miniUser = miniUserService.selectUserByOpenId(openId);
        if (miniUser == null){
            throw new MiniUserNotFoundException();
        }else {
            return AjaxResult.success("成功",miniUser);
        }
    }


    //增加用户
    @PostMapping("/insertUser")
    public AjaxResult insertUser(@RequestBody MiniUser miniUser){
//        miniUser.setOpenId(SecurityUtils.getUserId().toString());
        miniUser.setRegTime(new Date(System.currentTimeMillis()));
        miniUser.setStatus(1);
        if (miniUserService.insertUser(miniUser) >= 1){
            return AjaxResult.success("成功");
        }else {
            return AjaxResult.error("失败");
        }

    }

    /**
     * 修改小程序用户信息
     * @param miniUser
     * @return
     */
    @PostMapping("/updateUserMini")
    public AjaxResult updateUser(@RequestBody MiniUser miniUser){
        miniUserService.updateMiniUser(miniUser);
        return AjaxResult.success("更新用户信息成功");
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/getInfo")
    public AjaxResult getInfo(){
        String miniToken = MiniContextUtils.getMiniToken();
        Object objectBound = redisCache.getObjectBound(Constants.MINI_USER_LOGIN + miniToken);
        //MiniUserDto miniUserDto = BeanUtil.toBean(objectBound, MiniUserDto.class);
        return AjaxResult.success("成功",objectBound);
    }

    /**
     * 查询绑定人员信息
     * @return
     */
    @GetMapping("/queryBindPersonInfo")
    public AjaxResult queryBindPersonInfo(String code){
        if(StrUtil.isBlank(code)){
            return AjaxResult.error("参数异常");
        }
        TxPerson txPerson = miniUserService.selectBindPersonInfo(code);
        if(txPerson == null){
            //失败
            return AjaxResult.error("绑定信息不存在或已过期,请重新生成二维码");
        }
        return AjaxResult.success(txPerson);
    }

    /**
     * 绑定人员
     * @param code
     * @return
     */
    @PostMapping("/bindPerson")
    public AjaxResult bindPerson(@RequestBody String code){
        if(StrUtil.isBlank(code)){
            return AjaxResult.error("参数异常");
        }
        Object value = redisCache.getObjectBound(Constants.PERSON_BIND_CODE + code);
        if(value == null){
           return AjaxResult.error("绑定信息不存在或已过期");
        }
        Map<String, String> loginInfoMap = MiniContextUtils.getUserIdAndMiniToken();
        String userId = loginInfoMap.get("userId");
        MiniUser miniUser = new MiniUser();
        miniUser.setId(Long.valueOf(userId));
        miniUser.setIsAuditor(1);
        miniUser.setPersonId(Long.valueOf(value.toString()));
        int updateCount = miniUserService.bindPerson(miniUser);
        if(updateCount > 0){
            //更新小程序登录信息
            String miniToken = loginInfoMap.get("miniToken");
            Object objectBound = redisCache.getObjectBound(Constants.MINI_USER_LOGIN + miniToken);
            MiniUserDto miniUserDto = BeanUtil.toBean(objectBound, MiniUserDto.class);
            miniUserDto.setIsAuditor(1);
            miniUserDto.setPersonId(Long.valueOf(value.toString()));
            redisCache.setObjectBoundExpire(Constants.MINI_USER_LOGIN + miniToken,miniUserDto,60*60*24*3);
        }

        //清理缓存
        redisCache.deleteObject(Constants.PERSON_BIND_CODE + code);
        return AjaxResult.success("成功");
    }

}
