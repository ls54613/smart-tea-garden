package com.wanou.project.system.domain.vo;

import com.wanou.project.system.domain.TeaGarden;
import lombok.Data;

@Data
public class TeaGardenVo extends TeaGarden {
    private String teaTreeVarietyName; //茶树品种名称
    private String teaTypeName; //茶园类型名称
}
