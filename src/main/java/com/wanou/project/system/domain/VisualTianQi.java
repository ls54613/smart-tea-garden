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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWeatherStr() {
        return weatherStr;
    }

    public void setWeatherStr(String weatherStr) {
        this.weatherStr = weatherStr;
    }

    public String getNowWeatherStr() {
        return nowWeatherStr;
    }

    public void setNowWeatherStr(String nowWeatherStr) {
        this.nowWeatherStr = nowWeatherStr;
    }

    public String getTempStr() {
        return tempStr;
    }

    public void setTempStr(String tempStr) {
        this.tempStr = tempStr;
    }

    public String getNowTemp() {
        return nowTemp;
    }

    public void setNowTemp(String nowTemp) {
        this.nowTemp = nowTemp;
    }

    public String getNowHumidity() {
        return nowHumidity;
    }

    public void setNowHumidity(String nowHumidity) {
        this.nowHumidity = nowHumidity;
    }

    public String getNowWindSpeedStr() {
        return nowWindSpeedStr;
    }

    public void setNowWindSpeedStr(String nowWindSpeedStr) {
        this.nowWindSpeedStr = nowWindSpeedStr;
    }

    public BigDecimal getNowWindSpeed() {
        return nowWindSpeed;
    }

    public void setNowWindSpeed(BigDecimal nowWindSpeed) {
        this.nowWindSpeed = nowWindSpeed;
    }

    public BigDecimal getNowPrecipitation() {
        return nowPrecipitation;
    }

    public void setNowPrecipitation(BigDecimal nowPrecipitation) {
        this.nowPrecipitation = nowPrecipitation;
    }

    public String getNowPrecipitationStr() {
        return nowPrecipitationStr;
    }

    public void setNowPrecipitationStr(String nowPrecipitationStr) {
        this.nowPrecipitationStr = nowPrecipitationStr;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }
}
