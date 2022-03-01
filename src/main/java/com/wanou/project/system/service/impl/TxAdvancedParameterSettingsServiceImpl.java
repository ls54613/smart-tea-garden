package com.wanou.project.system.service.impl;
import com.wanou.project.system.domain.TxAdvancedParameterSettings;
import com.wanou.project.system.mapper.TxAdvancedParameterSettingsMapper;
import com.wanou.project.system.service.TxAdvancedParameterSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TxAdvancedParameterSettingsServiceImpl implements TxAdvancedParameterSettingsService {
    @Autowired
    TxAdvancedParameterSettingsMapper settingsMapper;

    @Override
    public TxAdvancedParameterSettings queryOne(String macAddr) {
        return settingsMapper.queryOne(macAddr);
    }

    @Override
    public int updateDevice(TxAdvancedParameterSettings txAdvancedParameterSettings) {
        return settingsMapper.updateDevice(txAdvancedParameterSettings);
    }
}
