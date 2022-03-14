package com.wanou.project.system.controller.openApi;

import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.project.system.domain.VisualTianQi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author txh
 * @date 2022/3/12 16:58
 */
@RestController
@RequestMapping("/openApi/common")
public class OpenCommonApiController {
    private static final String TIAN_QI_API = "https://way.jd.com/he/freeweather?city=CN{}&appkey=5c44a3cf6c0a3005bbe7efbafc483188";
    @Resource(name = "tianQiCache")
    private TimedCache<String, VisualTianQi> TIAN_QI_CACHE;

    @GetMapping("/getTianQi/{cityId}")
    public AjaxResult getTianQi(@PathVariable("cityId") String cityId){
        if(StringUtils.isNotBlank(cityId)){
            //查询缓存
            VisualTianQi visualTianQiInCache = TIAN_QI_CACHE.get(cityId, false);
            if(visualTianQiInCache != null){
                return AjaxResult.success(visualTianQiInCache);
            }
            String body = HttpRequest.get(StrUtil.format(TIAN_QI_API,cityId)).execute().body();
            JSONObject responseObj = JSON.parseObject(body, JSONObject.class);
            JSONObject result = BeanUtil.toBean(responseObj.get("result"), JSONObject.class);
            JSONArray heWeather5 = ((JSONArray)result.get("HeWeather5"));
            JSONObject data = BeanUtil.toBean(heWeather5.get(0), JSONObject.class);
            VisualTianQi visualTianQi = null;
            if(data != null){
                JSONObject nowData = BeanUtil.toBean(data.get("now"), JSONObject.class); //当前天气
                JSONArray dailyForecast = data.getJSONArray("daily_forecast"); //天气预报
                JSONObject todayData = BeanUtil.toBean(dailyForecast.get(0), JSONObject.class); //今日天气

                visualTianQi = new VisualTianQi();
                //气温
                visualTianQi.setNowTemp(nowData.get("tmp").toString() + "℃"); //当前气温
                JSONObject nowTemp = BeanUtil.toBean(todayData.get("tmp"), JSONObject.class); //今日气温
                String todayMinTmp = nowTemp.getString("min"); //今日最低气温
                String todayMaxTmp = nowTemp.getString("max"); //今日最高气温
                visualTianQi.setTempStr(StrUtil.format("{}℃~{}℃",todayMinTmp,todayMaxTmp));

                //天气
                JSONObject nowCond = BeanUtil.toBean(nowData.get("cond"), JSONObject.class); //当前天气
                visualTianQi.setNowWeatherStr(nowCond.getString("txt"));
                JSONObject todayCond = BeanUtil.toBean(todayData.get("cond"), JSONObject.class);
                String todayDay = todayCond.getString("txt_d"); //今日白天天气
                String todayNight = todayCond.getString("txt_n"); //今日晚间天气
                if(!todayDay.equals(todayNight)){ //设置今日天气
                    visualTianQi.setWeatherStr(StrUtil.format("{}转{}",todayDay,todayNight));
                }else {
                    visualTianQi.setWeatherStr(todayDay);
                }

                //湿度
                String nowHum = nowData.getString("hum"); //当前湿度
                visualTianQi.setNowHumidity(nowHum);

                //风速
                JSONObject nowWind = nowData.getJSONObject("wind"); //当前风信息
                BigDecimal spd = nowWind.getBigDecimal("spd"); //风速
                BigDecimal spdMeter = NumberUtil.mul(spd, 1000); //风速/米
                BigDecimal spdMeterPerSecond = NumberUtil.div(spdMeter, 3600); //风速 m/s
                visualTianQi.setNowWindSpeed(NumberUtil.round(spdMeterPerSecond,1));
                visualTianQi.setNowWindSpeedStr(NumberUtil.round(spdMeterPerSecond,1) + "m/s");
                visualTianQi.setWindDirection(nowWind.getString("dir"));

                //降水
                BigDecimal precipitation = nowData.getBigDecimal("pcpn"); //当前降水量
                visualTianQi.setNowPrecipitation(precipitation);
                visualTianQi.setNowPrecipitationStr(precipitation + "mm");

                //PM2.5
                JSONObject aqi = data.getJSONObject("aqi");
                String pm25 = aqi.getJSONObject("city").getString("pm25");
                visualTianQi.setPm25(pm25);
            }

            //存入缓存
            TIAN_QI_CACHE.put(cityId,visualTianQi);
            return AjaxResult.success(visualTianQi);
        }

        return AjaxResult.success();
    }
}
