package com.wanou.project.system.domain.openApi;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author txh
 * @date 2022/3/8 11:02
 */
@Data
public class TeaEnterpriseTotal implements Serializable {
    private static final long serialVersionUID = 7828698283619499551L;

    private BigDecimal plantArea; //种植面积
    private BigDecimal yield; //产量(亿元)
    private BigDecimal productionValue; //产值(万吨)
    private Integer teaGardenCount; //茶园个数
    private Integer teaEnterPriseCount; //茶企个数
    private Integer teaPeasantCount; //茶农人数
}
