package com.avo.avocado.utils.dtos;

import com.avo.avocado.utils.enums.Gender;
import com.avo.avocado.utils.enums.LevelOfActivity;
import lombok.Data;

@Data
public class CaloricNeedsDTO {
    private LevelOfActivity level_of_activity;
    private Integer age;
    private Double height;
    private Double weight;
    private Gender gender;
}
