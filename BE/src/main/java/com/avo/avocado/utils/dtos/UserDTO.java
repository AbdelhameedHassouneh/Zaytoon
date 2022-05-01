package com.avo.avocado.utils.dtos;

import com.avo.avocado.utils.enums.Gender;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class UserDTO {
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private Integer age;
    private Double height;
    private Double weight;
    private String password;
    private Gender gender;
}
