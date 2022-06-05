package com.avo.zaytoon.utils.dtos;

import com.avo.zaytoon.utils.enums.Gender;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class UserDTO {
    private Integer id;
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
