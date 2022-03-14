package com.wanou.project.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author txh
 * @date 2021/11/3 10:20
 * 天气实体类
 */
@Data
public class VisualTianQi implements Serializable {
    private static final long serialVersionUID = 4191229195920706957L;

    private String weatherStr; //今日天气
    private String nowWeatherStr; //当前天气
    private String tempStr; //今日温度范围加℃字符串
    private String nowTemp; //当前温度
    private String nowHumidity; //当前湿度
    private String nowWindSpeedStr; //当前风速字符串
    private BigDecimal nowWindSpeed; //风速
    private BigDecimal nowPrecipitation; //当前降水量
    private String nowPrecipitationStr; //当前降水量字符串
    private String windDirection; //风向
    private String pm25; //pm2.5
}
