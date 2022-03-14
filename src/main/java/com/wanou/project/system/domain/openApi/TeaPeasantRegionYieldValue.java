package com.wanou.project.system.domain.openApi;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TeaPeasantRegionYieldValue implements Serializable {
    private static final long serialVersionUID = 7828698283619499551L;

    private Integer personNumber;//人数

    private BigDecimal yieldValueNum;//产量

    private BigDecimal yieldValueMoney;//产值

    private String region;//地区
}
