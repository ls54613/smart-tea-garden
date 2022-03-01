package com.wanou.project.system.service;


import com.wanou.project.system.domain.TxAdvancedParameterSettings;

public interface TxAdvancedParameterSettingsService {
    //查询当前设备参数
    TxAdvancedParameterSettings queryOne(String macAddr);
    //修改当前设备参数
    int updateDevice(TxAdvancedParameterSettings txAdvancedParameterSettings);

}
