package com.wanou.project.system.mapper;

import com.wanou.project.system.domain.TxAdvancedParameterSettings;
import org.springframework.stereotype.Repository;

@Repository
public interface TxAdvancedParameterSettingsMapper {
    //查询当前设备参数
    TxAdvancedParameterSettings queryOne(String macAddr);

    //修改当前设备参数
    int updateDevice(TxAdvancedParameterSettings txAdvancedParameterSettings);
}
