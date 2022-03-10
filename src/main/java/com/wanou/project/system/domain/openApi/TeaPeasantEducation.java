package com.wanou.project.system.domain.openApi;

import lombok.Data;

import java.io.Serializable;
@Data
public class TeaPeasantEducation implements Serializable {
    private static final long serialVersionUID = 7828698283619499551L;

    /**private Integer primarySchool;//小学

    private Integer middleSchool;//初中

    private Integer highSchool;//高中

    private Integer juniorCollege;//大专

    private Integer undergraduate;//本科

    private Integer graduateStudent;//研究生*/

    private String education;
    private Integer educationNumber;
}
