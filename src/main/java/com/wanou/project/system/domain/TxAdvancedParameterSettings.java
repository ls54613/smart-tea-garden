package com.wanou.project.system.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 设备高级参数设置
 */
@Data
public class TxAdvancedParameterSettings implements Serializable {
    private String json;
    private int videoSwitch;
    private int bannerSpacetime;
    private int bannerEnable;
    private String banner;
    private int wgOutType;
    private int outsideDetectMode;
    private int tempThermography;
    private String tempNormalMax;
    private int temperatureMode;
    private int rebootTime;
    private int recogRelay;
    private int detectVoiceEnable;
    private int recogModeic;
    private int recogModedb;
    private int livenessValue;
    private int InfraredImaging;
    private int livenessEnable;
    private int detectRange;
    private int lightType;
    private int whiteValue;
    private int mapValue;
    private int recogSpaceTime;
    private int LevelPercent;
    private int lightLevelPercent;
    private String macAddr;
    private String deviceId;
    //新增参数
    private Integer VBM;
    private String VBMInfo;
    private Integer SDM;
    private String SDMInfo;
    private Integer WiegandTypeRelay;
    private Integer FaceRecoCheckHealthCode;
    private String SwipePrompt;
    private Integer MeasureMode;
    private String MeasurePrompt;
    private Integer Stranger;
    private Integer EnableHealthCode;
    private Integer EnableVerifyFace;

    //新增参数2.0
    // 身份证、二维码启用人脸识别
    private Integer EnableIdRecognise;
    private Integer EnableQrRecognise;

    // 是否启用身份证、二维码处理流程
    private Integer EnableIdProcess;
    private Integer EnableQrProcess;
}
