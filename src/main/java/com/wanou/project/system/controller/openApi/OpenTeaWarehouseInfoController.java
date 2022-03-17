package com.wanou.project.system.controller.openApi;

import com.alibaba.fastjson.JSONObject;
import com.wanou.common.core.domain.AjaxResult;
import com.wanou.project.system.domain.TeaWarehouseEssential;
import com.wanou.project.system.domain.openApi.TeaValueDistribution;
import com.wanou.project.system.service.ITeaWarehouseCurrentValueService;
import com.wanou.project.system.service.ITeaWarehouseEssentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/openApi/teaWarehouseInfo")
public class OpenTeaWarehouseInfoController {
    @Autowired
    private ITeaWarehouseEssentialService teaWarehouseEssentialService;

    @Autowired
    private ITeaWarehouseCurrentValueService teaWarehouseCurrentValueService;

    /**
     * 获取茶仓基本信息
     * */
    @GetMapping("/getWarehouseInformation")
    public AjaxResult getWarehouseInformation(long id){
        JSONObject teaWarehouseEssential=teaWarehouseEssentialService.getWarehouseInformation(id);
        return AjaxResult.success(teaWarehouseEssential);
    }

    /**
     * 货值分布
     * */
    /*@GetMapping("/getValueDistribution")
    public AjaxResult getValueDistribution(){
        List<TeaValueDistribution> teaValueDistributionList=teaWarehouseEssentialService.getValueDistribution();
        return AjaxResult.success(teaValueDistributionList);
    }*/

    /**
     * 获取茶仓情况
     * */
    @GetMapping("/getTeaWarehouse")
    public AjaxResult getTeaWarehouse(int teaWarehouseId){
        JSONObject teaWarehouse=teaWarehouseEssentialService.getTeaWarehouse(teaWarehouseId);
        return AjaxResult.success(teaWarehouse);
    }

    /**
     * 出入仓预警
     * */
    @GetMapping("/getWarehouseInAndOutWarning")
    public AjaxResult getWarehouseInAndOutWarning(int teaWarehouseId){
        List<JSONObject> jsonObjectList=teaWarehouseEssentialService.getWarehouseInAndOutWarning(teaWarehouseId);
        return AjaxResult.success(jsonObjectList);
    }


    /**
     * 茶仓以及茶品种的货值分布
     * */
    @GetMapping("/getValueDistribution")
    public AjaxResult getValueDistribution(int teaWarehouseId){
        List<JSONObject> jsonObjectList=teaWarehouseCurrentValueService.getValueDistribution(teaWarehouseId);
        return AjaxResult.success(jsonObjectList);
    }

    /**
     *仓库利用率分析
     * */
    @GetMapping("/getCapacityAndWarehousingAndOut")
    public AjaxResult getCapacityAndWarehousingAndOut(int teaWarehouseId){
        List<JSONObject> jsonObjectList=teaWarehouseEssentialService.getCapacityAndWarehousingAndOut(teaWarehouseId);
        return AjaxResult.success(jsonObjectList);
    }

    /**
     * 3.16
     *获取企业名称以及对应的所有茶仓的容量以及出库总量
     * */
    @GetMapping("/getEnterpriseNameCapacity")
    public AjaxResult getEnterpriseNameCapacity(){
        List<JSONObject> jsonObjectList=teaWarehouseEssentialService.getEnterpriseNameCapacity();
        return AjaxResult.success(jsonObjectList);
    }
}




