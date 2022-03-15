package com.wanou.project.system.controller.openApi;

import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.project.system.service.ITeaGardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
