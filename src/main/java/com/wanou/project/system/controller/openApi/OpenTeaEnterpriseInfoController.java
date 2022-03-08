package com.wanou.project.system.controller.openApi;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.wanou.common.core.domain.AjaxResult;
import com.wanou.project.system.domain.TeaEnterpriseInfo;
import com.wanou.project.system.domain.openApi.TeaEnterpriseTotal;
import com.wanou.project.system.service.ITeaEnterpriseInfoService;
import com.wanou.project.system.service.ITeaEnterpriseYieldSalesService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/getTotal")
    public AjaxResult getTotal(){
        TeaEnterpriseTotal teaEnterpriseTotal = teaEnterpriseInfoService.getTotal();
        return AjaxResult.success(teaEnterpriseTotal);
    }


    @GetMapping("/getYieldSalesTotal")
    public AjaxResult getYieldSalesTotal(){
        DateTime nowDate = DateUtil.date();
        DateTime start = DateUtil.offset(nowDate, DateField.YEAR, -5);
        DateTime end = DateUtil.offset(nowDate, DateField.YEAR, -1);

        List<Map<String,List>> result = teaEnterpriseYieldSalesService.selectTeaEnterpriseYieldSalesTotalRange(DateUtil.year(start),DateUtil.year(end));

        List<Integer> rangeList = DateUtil.rangeFunc(start, end, DateField.YEAR, DateUtil::year);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("yearList",rangeList);
        jsonObject.put("data",result);
        return AjaxResult.success(jsonObject);
    }

    @GetMapping("/getTeaSalesTypes")
    public AjaxResult getTeaSalesTypes(){
        List<JSONObject> result = teaEnterpriseInfoService.getTeaSalesTypes();
        return AjaxResult.success(result);
    }

    @GetMapping("/getSalesYearOnYear")
    public AjaxResult getSalesYearOnYear(){
        JSONObject result = teaEnterpriseYieldSalesService.getSalesYearOnYear();
        return AjaxResult.success(result);
    }
}
