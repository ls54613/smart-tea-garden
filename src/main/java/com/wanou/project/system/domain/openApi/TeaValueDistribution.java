package com.wanou.project.system.domain.openApi;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeaValueDistribution implements Serializable {
    private static final long serialVersionUID = 7828698283619499551L;

    private String teaVarieties;

    private Integer varietiesNumber;

}
