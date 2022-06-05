package com.avo.zaytoon.utils.dtos;

import com.avo.zaytoon.utils.enums.Gender;
import com.avo.zaytoon.utils.enums.LevelOfActivity;
import lombok.Data;

@Data
public class CaloricNeedsDTO {
    private LevelOfActivity level_of_activity;
    private Integer age;
    private Double height;
    private Double weight;
    private Gender gender;
}
