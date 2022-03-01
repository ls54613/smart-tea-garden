package com.wanou.project.system.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.DesensitizedUtil;
import com.wanou.common.component.OSS.OSSComponent;
import com.wanou.common.constant.Constants;
import com.wanou.common.exception.MiniUserNotFoundException;
import com.wanou.common.exception.NoBindMiniUserException;
import com.wanou.common.utils.image.ImageUtil;
import com.wanou.framework.redis.RedisCache;
import com.wanou.framework.security.mini.MiniContextUtils;
import com.wanou.project.applet.domain.MiniUser;
import com.wanou.project.system.domain.TxPerson;
import com.wanou.project.system.mapper.MiniUserMapper;
import com.wanou.project.system.service.ITxPersonService;
import com.wanou.project.system.service.MiniUserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MiniUserServiceImpl implements MiniUserService {
    @Autowired
    MiniUserMapper miniUserMapper;
    @Value("${mini.oss-head-image-prefix}")
    private String miniHeadImgPre;  //小程序用户头像oss前缀
    @Autowired
    private OSSComponent ossComponent;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private ITxPersonService personService;

    @Override
    public List<MiniUser> listMiniUserInfo() {
        return miniUserMapper.listMiniUserInfo();
    }

    @Override
    public int updateMiniUser(MiniUser miniUser) {
        if(miniUser.getId() == null){
            Long userId = MiniContextUtils.getUserId();
            miniUser.setId(userId);
        }

        String[] split = miniUser.getPortrait().split(",");
        if(Base64.isBase64(split[split.length - 1])){
            //上传头像数据到OSS
            String objName = miniHeadImgPre + miniUser.getOpenId() + "." + ImageUtil.checkImageBase64Format(split[split.length - 1]);
            String[] portraitSplitArr = miniUser.getPortrait().split(",");
            if(portraitSplitArr.length > 1){
                miniUser.setPortrait(portraitSplitArr[1]);
            }else {
                return 0;
            }
            byte[] decode = Base64.decode(miniUser.getPortrait());
            ossComponent.uploadByte(objName,decode);
            miniUser.setPortrait(objName);
        }

        return miniUserMapper.updateMiniUser(miniUser);
    }

    @Override
    public int deleteMiniUserById(long id) {
        return miniUserMapper.deleteMiniUserById(id);
    }




    /**
     *
     *
     *
     *
     * 小程序端service实现类
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
    @Override
    public int insertUser(MiniUser miniUser) {
        int i = miniUserMapper.insertUser(miniUser);
        return i;
    }

    /**
     * Description: 根据微信Id查询用户
     * @param openId: 微信Id
     * @return:
     */
    @Override
    public MiniUser selectUserByOpenId(String openId) {
        return miniUserMapper.selectUserByOpenId(openId);
    }

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    @Override
    public MiniUser selectUserById(Long userId) {
        MiniUser miniUser = miniUserMapper.selectUserByUserId(userId);
        if(miniUser == null){
            throw new MiniUserNotFoundException();
        }
        return miniUser;
    }

    /**
     * 查询绑定人员信息
     * @param code
     * @return
     */
    @Override
    public TxPerson selectBindPersonInfo(String code) {
        Object value = redisCache.getObjectBound(Constants.PERSON_BIND_CODE + code);
        if(value == null){
            return null;
        }
        //获取人员信息
        TxPerson txPerson = personService.selectTxPersonByStaffid(Long.valueOf(value.toString()));
        if(txPerson == null){
            return null;
        }
        //脱敏
        TxPerson result = new TxPerson();
        String mobile = DesensitizedUtil.mobilePhone(txPerson.getMobile());
        result.setMobile(mobile);
        result.setName(DesensitizedUtil.chineseName(txPerson.getName()));
        result.setImgBase64(txPerson.getImgBase64());
        return result;
    }

    /**
     * 绑定人员
     * @param miniUser
     */
    @Override
    public int bindPerson(MiniUser miniUser) {
        return miniUserMapper.updateMiniUser(miniUser);
    }
}
