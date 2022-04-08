package com.wanou.project.system.controller.openApi;

import com.alibaba.fastjson.JSONObject;
import com.wanou.common.core.domain.AjaxResult;
import com.wanou.project.system.domain.TeaPeasantAnnual;
import com.wanou.project.system.domain.TeaPeasantAsset;
import com.wanou.project.system.domain.TeaPeasantFamily;
import com.wanou.project.system.domain.TeaPeasantYieldSales;
import com.wanou.project.system.domain.openApi.TeaEnterpriseTotal;
import com.wanou.project.system.domain.openApi.TeaPeasantEducation;
import com.wanou.project.system.domain.openApi.TeaPeasantRegionYieldValue;
import com.wanou.project.system.domain.openApi.TeaPersonalInformation;
import com.wanou.project.system.service.*;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

/**
 * 茶农基本信息Controller
 *
 * @author MrYao
 * @date 2022-03-02
 */
@RestController
@RequestMapping("/openApi/teaPeasantInfo")
public class OpenTeaPeasantInfoController {

    @Autowired
    private ITeaEnterpriseInfoService teaEnterpriseInfoService;

    @Autowired
    private ITeaPeasantInfoService teaPeasantInfoService;

    @Autowired
    private ITeaPeasantFamilyService teaPeasantFamilyService;

    @Autowired
    private ITeaPeasantAnnualService teaPeasantAnnualService;

    @Autowired
    private ITeaPeasantAssetService teaPeasantAssetService;

    @Autowired
    private ITeaPeasantYieldSalesService teaPeasantYieldSalesService;

    @Autowired
    private ITeaPeasantIncomeService teaPeasantIncomeService;

    @Autowired
    private ITeaPeasantIncomeSituationService teaPeasantIncomeSituationService;

    @GetMapping("/getTotal")
    public AjaxResult getTotal(){
        TeaEnterpriseTotal teaEnterpriseTotal = teaEnterpriseInfoService.getTotal();
        return AjaxResult.success(teaEnterpriseTotal);
    }

    /**
     * 获取茶农文化程度统计
     * */
    @GetMapping("/getPeasantEducation")
    public AjaxResult getPeasantEducation(){
        List<JSONObject>  result= teaPeasantInfoService.getPeasantEducation();
        Integer max = result.stream().max(Comparator.comparing(item -> item.getInteger("educationNumber"))).map(item -> item.getInteger("educationNumber")).get();
        JSONObject finalResult = new JSONObject();
        finalResult.put("max",max);
        finalResult.put("data",result);
      return AjaxResult.success(finalResult);
    }

    /**
     * 获取茶农总人数
     * */
    @GetMapping("/getTotalNumber")
    public AjaxResult getTotalNumber(){
       int totalNumber= teaPeasantInfoService.getTotalNumber();
       return AjaxResult.success(totalNumber);
    }

    /**
     * 获取茶农基本信息
     * */
    @GetMapping("/getTeaPersonalInformation")
    public AjaxResult getPeasantInfo(int id){
        TeaPersonalInformation teaPersonalInformation= teaPeasantInfoService.getTeaPersonalInformation(id);
        return AjaxResult.success(teaPersonalInformation);
    }

    /**
     * 根据茶农id获取家庭成员
     * */
    @GetMapping("/getMemberOfFamily")
    public AjaxResult getMemberOfFamily(long teaPeasantId){
        TeaPeasantFamily teaPeasantFamily=teaPeasantFamilyService.getMemberOfFamily(teaPeasantId);
        return AjaxResult.success(teaPeasantFamily);
    }

    /**
     * 根据茶农id获取收入组成
     * */
    @GetMapping("/getPeasantAnnual")
    public AjaxResult getPeasantAnnual(long teaPeasantId){
        JSONObject teaPeasantAnnual= teaPeasantAnnualService.getPeasantAnnual(teaPeasantId);
        return AjaxResult.success(teaPeasantAnnual);
    }

    /**
     * 根据茶农id获取资产情况
     * */
    @GetMapping("/getPeasantAsset")
    public AjaxResult getPeasantAsset(long teaPeasantId){
        TeaPeasantAsset teaPeasantAsset=teaPeasantAssetService.getpeasantasset(teaPeasantId);
        return AjaxResult.success(teaPeasantAsset);
    }

    /**
     * 根据茶农id获取产量及年份
     * */
    @GetMapping("/getYieldValueNumber")
    public AjaxResult getYieldValueNumber(long teaPeasantId){
        List<TeaPeasantYieldSales> teaPeasantYieldSales= teaPeasantYieldSalesService.getYieldValueNumber(teaPeasantId);
        return AjaxResult.success(teaPeasantYieldSales);
    }

    /**
     * 根据茶农id获取产值及年份
     *
     * */
    @GetMapping("/getYieldValueMoney")
    public AjaxResult getYieldValueMoney(long teaPeasantId){
        List<TeaPeasantYieldSales> teaPeasantYieldSales= teaPeasantYieldSalesService.getYieldValueMoney(teaPeasantId);
        return AjaxResult.success(teaPeasantYieldSales);
    }

    /**
     * 获取茶农所在的区域以及产量和产值
     * */
    @GetMapping("/getPeasantRegionYieldValue")
    public AjaxResult getPeasantRegionYieldValue(){
        List<TeaPeasantRegionYieldValue> teaPeasantRegionYieldValues=teaPeasantInfoService.getPeasantRegionYieldValue();
        return AjaxResult.success(teaPeasantRegionYieldValues);
    }

    /**
     * 茶农人均与总体人均的收入
     * */
    @GetMapping("/getPeasantIncomeSituationService")
    public AjaxResult getPeasantIncomeSituationService(){
        List<JSONObject> jsonObjectList=teaPeasantIncomeSituationService.getPeasantIncomeSituationService();
        return AjaxResult.success(jsonObjectList);
    }

    /**
     *
     *种植大户收入
     */
    @GetMapping("/getLargeHouseholdIncome")
    public AjaxResult getLargeHouseholdIncome(){
        JSONObject jsonObjectList= teaPeasantInfoService.getLargeHouseholdIncome();
        return AjaxResult.success(jsonObjectList);
    }
}










