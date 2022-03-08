package com.wanou.project.system.controller.openApi;

import com.wanou.common.core.domain.AjaxResult;
import com.wanou.project.system.domain.TeaEnterpriseInfo;
import com.wanou.project.system.domain.openApi.TeaEnterpriseTotal;
import com.wanou.project.system.service.ITeaEnterpriseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openApi/teaEnterpriseInfo")
public class OpenTeaEnterpriseInfoController {
    @Autowired
    private ITeaEnterpriseInfoService teaEnterpriseInfoService;

    @GetMapping("/getTotal")
    public AjaxResult getTotal(){
        TeaEnterpriseTotal teaEnterpriseTotal = teaEnterpriseInfoService.getTotal();
        return AjaxResult.success(teaEnterpriseTotal);
    }
}
