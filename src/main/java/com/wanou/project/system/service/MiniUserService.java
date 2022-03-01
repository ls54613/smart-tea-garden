package com.wanou.project.system.service;

import com.wanou.project.applet.domain.MiniUser;
import com.wanou.project.system.domain.TxPerson;

import java.util.List;

public interface MiniUserService {
    //获取注册信息列表
    List<MiniUser> listMiniUserInfo();
    //修改当前用户
    int updateMiniUser(MiniUser miniUser);
    //删除当前用户
    int deleteMiniUserById(long id);


    /**
     *
     *
     *
     *
     * 小程序端接口
     *
     *
     *
     * */



    /**
     * Description: 插入用户
     * @param miniUser: 插入用户信息
     * @return: 返回插入信息
     * @date: 2021/8/18 15:15
     */
    public int insertUser(MiniUser miniUser);



    /**
     * Description: 根据微信Id查询用户
     * @param openId: 微信Id
     * @return:
     */
    public MiniUser selectUserByOpenId(String openId);

    MiniUser selectUserById(Long userId);

    /**
     * 查询绑定人员信息
     * @param code
     * @return
     */
    TxPerson selectBindPersonInfo(String code);

    /**
     * 绑定人员
     * @param miniUser
     */
    int bindPerson(MiniUser miniUser);
}
