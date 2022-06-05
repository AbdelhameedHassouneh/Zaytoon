package com.avo.zaytoon.utils.entites;

import com.avo.zaytoon.utils.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class UserResponse implements ServiceEntity {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("last_name")
    private String last_name;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("height")
    private Double height;

    @JsonProperty("weight")
    private Double weight;

    @JsonProperty("gender")
    private Gender gender;

}
