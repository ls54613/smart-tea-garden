package com.wanou.project.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author txh
 * @date 2022/3/14 11:54
 * 茶园种植品种
 */
@Data
public class TeaGardenType implements Serializable {
    private static final long serialVersionUID = -6693251137570983230L;

    private Long teaGardenId; //茶园id
    private Integer type; //茶种类 1=碧香早2=楮叶齐3=黄金茶4=安吉白茶5=福鼎大白6=梅占
    private BigDecimal proportion; //占比(%)
}
