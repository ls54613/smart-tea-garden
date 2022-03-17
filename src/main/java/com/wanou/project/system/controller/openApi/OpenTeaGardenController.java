package com.wanou.project.system.controller.openApi;

import cn.hutool.json.JSONObject;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.project.system.service.ITeaGardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author txh
 * @date 2022/3/14 11:39
 * 茶园开放接口
 */
@RestController
@RequestMapping("/openApi/teaGarden")
public class OpenTeaGardenController {
    @Autowired
    private ITeaGardenService teaGardenService;



    /**
     * 种植品种分析
     * @return
     */
    @GetMapping("/getTeaTypes")
    public AjaxResult getTeaTypes(String region){

        return AjaxResult.success();
    }

    /**
     * 获取茶园总面积，总产量，茶企名称
     * */
    @GetMapping("/getEnterpriseNameAndArea")
    public AjaxResult getEnterpriseNameAndArea(){
        List<JSONObject> jsonObjectList=teaGardenService.getEnterpriseNameAndArea();
        return AjaxResult.success(jsonObjectList);
    }

    /**
     *
     * 根据地区查出所有茶园个数以及这个地区茶园的面积以及总产量
     * */
    @GetMapping("/getRegionAverageYieldAndTeaArea")
    public AjaxResult getRegionAverageYieldAndTeaArea(){
        List<JSONObject> objects=teaGardenService.getRegionAverageYieldAndTeaArea();
        return AjaxResult.success(objects);
    }


    /**
     * 茶园种植品种分析
     * */
    @GetMapping("/getProportionYieldAndDictLabel")
    public AjaxResult getProportionYieldAndDictLabel(){
        List<JSONObject> objects=teaGardenService.getProportionYieldAndDictLabel();
        return AjaxResult.success(objects);
    }

    /**
     * 获取茶园基本信息
     * */
    @GetMapping("/getTeaGardenInformation")
    public AjaxResult getTeaGardenInformation(String name){
        JSONObject object=teaGardenService.getTeaGardenInformation(name);
        return AjaxResult.success(object);
    }
}
