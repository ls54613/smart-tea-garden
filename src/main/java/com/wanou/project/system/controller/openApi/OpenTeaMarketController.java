package com.wanou.project.system.controller.openApi;

import cn.hutool.json.JSONObject;
import com.wanou.framework.web.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wanou.project.system.service.ITeaMarketYearService;
import springfox.documentation.spring.web.json.Json;
import com.wanou.project.system.service.ITeaMarketProportionService;
import com.wanou.project.system.service.ITeaMarketPreferenceRateService;
import com.wanou.project.system.service.ITeaMarketScaleService;

import java.util.List;

@RestController
@RequestMapping("/openApi/teaMarket")
public class OpenTeaMarketController {
    @Autowired
    private ITeaMarketYearService teaMarketYearService;
    @Autowired
    private ITeaMarketProportionService teaMarketProportionService;
    @Autowired
    private ITeaMarketPreferenceRateService teaMarketPreferenceRateService;
    @Autowired
    private ITeaMarketScaleService teaMarketScaleService;

    /**
     * 获取2017-2020中国茶叶销售量
     * */
    @GetMapping("/getTeaSalesChina")
    public AjaxResult getTeaSalesChina(){
        List<JSONObject> objectList=teaMarketYearService.getTeaSalesChina();
        return AjaxResult.success(objectList);
    }

    /**
     * 常宁茶叶线上线下销售占比
     * */
    @GetMapping("/getProportionOfSalesVolume")
    public AjaxResult getProportionOfSalesVolume(){
        List<JSONObject> objects=teaMarketYearService.getProportionOfSalesVolume();
        return AjaxResult.success(objects);
    }

    /**
     * 中国茶叶人均消费量
     * */
    @GetMapping("/getPerCapitaConsumption")
    public AjaxResult getPerCapitaConsumption(){
        List<JSONObject> jsonObjectList=teaMarketYearService.getPerCapitaConsumption();
        return AjaxResult.success(jsonObjectList);
    }

    /**
     * 常宁茶叶消费量情况
     * */
    @GetMapping("/getTeaConsumption")
    public AjaxResult getTeaConsumption(){
        List<JSONObject> jsonObjectList=teaMarketYearService.getTeaConsumption();
        return AjaxResult.success(jsonObjectList);
    }

    /**
     * 获取常宁茶叶产量
     * */
    @GetMapping("/getChangNingTeaYield")
    public AjaxResult getChangNingTeaYield(){
        List<JSONObject> jsonObjectList=teaMarketYearService.getChangNingTeaYield();
        return AjaxResult.success(jsonObjectList);
    }

    /**
     * 各品种产量占比情况
     * */
    @GetMapping("/getTypeProportion")
    public AjaxResult getTypeProportion(){
        List<JSONObject> jsonObjectList=teaMarketYearService.getTypeProportion();
        return AjaxResult.success(jsonObjectList);
    }

    /**
     *获取销售品类检测数据
     * */
    @GetMapping("/getSaleTypeTestData")
    public AjaxResult getSaleTypeTestData(){
        List<JSONObject> jsonObjectList=teaMarketPreferenceRateService.getSaleTypeTestData();
        return AjaxResult.success(jsonObjectList);
    }

    /**
     *获取中国茶叶线上销售规模检测数据
     * */
    @GetMapping("/getOnlineSalesTestData")
    public AjaxResult getOnlineSalesTestData(){
        List<JSONObject> jsonObjectList=teaMarketScaleService.getOnlineSalesTestData();
        return AjaxResult.success(jsonObjectList);
    }
}
