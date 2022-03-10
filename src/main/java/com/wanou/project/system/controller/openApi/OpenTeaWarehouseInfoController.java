package com.wanou.project.system.controller.openApi;

import com.wanou.common.core.domain.AjaxResult;
import com.wanou.project.system.domain.TeaWarehouseEssential;
import com.wanou.project.system.domain.openApi.TeaValueDistribution;
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

    /**
     * 获取茶仓基本信息
     * */
    @GetMapping("/getWarehouseInformation")
    public AjaxResult getWarehouseInformation(long id){
        TeaWarehouseEssential teaWarehouseEssential=teaWarehouseEssentialService.getWarehouseInformation(id);
        return AjaxResult.success(teaWarehouseEssential);
    }

    /**
     * 货值分布
     * */
    @GetMapping("/getValueDistribution")
    public AjaxResult getValueDistribution(){
        List<TeaValueDistribution> teaValueDistributionList=teaWarehouseEssentialService.getValueDistribution();
        return AjaxResult.success(teaValueDistributionList);
    }
}




