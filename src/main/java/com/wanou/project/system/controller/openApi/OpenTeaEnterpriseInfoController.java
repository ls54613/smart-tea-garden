package com.wanou.project.system.controller.openApi;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.wanou.common.core.domain.AjaxResult;
import com.wanou.project.system.domain.TeaEnterpriseInfo;
import com.wanou.project.system.domain.openApi.TeaEnterpriseTotal;
import com.wanou.project.system.service.ITeaEnterpriseInfoService;
import com.wanou.project.system.service.ITeaEnterpriseProcurementService;
import com.wanou.project.system.service.ITeaEnterpriseYieldSalesService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/openApi/teaEnterpriseInfo")
public class OpenTeaEnterpriseInfoController {
    @Autowired
    private ITeaEnterpriseInfoService teaEnterpriseInfoService;
    @Autowired
    private ITeaEnterpriseYieldSalesService teaEnterpriseYieldSalesService;
    @Autowired
    private ITeaEnterpriseProcurementService teaEnterpriseProcurementService;

    @GetMapping("/getTotal")
    public AjaxResult getTotal(){
        TeaEnterpriseTotal teaEnterpriseTotal = teaEnterpriseInfoService.getTotal();
        return AjaxResult.success(teaEnterpriseTotal);
    }


    /**
     * 历年销量及销售额统计
     * @return
     */
    @GetMapping("/getYieldSalesTotal")
    public AjaxResult getYieldSalesTotal(Long id){
        DateTime nowDate = DateUtil.date();
        DateTime start = DateUtil.offset(nowDate, DateField.YEAR, -5);
        DateTime end = DateUtil.offset(nowDate, DateField.YEAR, -1);

        List<Map<String,List>> result = teaEnterpriseYieldSalesService.selectTeaEnterpriseYieldSalesTotalRange(id,DateUtil.year(start),DateUtil.year(end));

        List<Integer> rangeList = DateUtil.rangeFunc(start, end, DateField.YEAR, DateUtil::year);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("yearList",rangeList);
        jsonObject.put("data",result);
        return AjaxResult.success(jsonObject);
    }

    @GetMapping("/getTeaSalesTypes")
    public AjaxResult getTeaSalesTypes(String region){
        List<JSONObject> result = teaEnterpriseInfoService.getTeaSalesTypes(region);
        return AjaxResult.success(result);
    }

    @GetMapping("/getSalesYearOnYear")
    public AjaxResult getSalesYearOnYear(){
        JSONObject result = teaEnterpriseYieldSalesService.getSalesYearOnYear();
        return AjaxResult.success(result);
    }

    @GetMapping("/getYieldGroupRegion")
    public AjaxResult getYieldGroupRegion(){
        List<JSONObject> result =  teaEnterpriseInfoService.getYieldGroupRegion();
        int count = teaEnterpriseInfoService.selectTeaEnterpriseCount();
        JSONObject data = new JSONObject();
        data.put("data",result);
        data.put("count",count);
        return AjaxResult.success(data);
    }

    @GetMapping("/getSalesByRegion")
    public AjaxResult getSalesByRegion(String region){
        List<JSONObject> result = teaEnterpriseYieldSalesService.getSalesByRegion(region);
        return AjaxResult.success(result);
    }

    /**
     * 获取茶企基本信息
     * @param id 茶企id
     * @return
     */
    @GetMapping("/getBaseInfo/{id}")
    public AjaxResult getBaseInfo(@PathVariable("id") Long id){
        TeaEnterpriseInfo teaEnterpriseInfo = teaEnterpriseInfoService.selectTeaEnterpriseInfoById(id);
        return AjaxResult.success(teaEnterpriseInfo);
    }

    /**
     * 历年成本及利润统计
     * @param id
     * @return
     */
    @GetMapping("/costAndProfitStatistics/{id}")
    public AjaxResult costAndProfitStatistics(@PathVariable("id")Long id){
        List<JSONObject> result = teaEnterpriseYieldSalesService.costAndProfitStatistics(id);
        return AjaxResult.success(result);
    }

    /**
     * 企业采购监测
     * @param id
     * @return
     */
    @GetMapping("/purchaseMonitor")
    public AjaxResult purchaseMonitor(Long id){
        List<JSONObject> result = teaEnterpriseProcurementService.selectTeaEnterpriseProcurementByEnterpriseId(id);
        return AjaxResult.success(result);
    }
}
