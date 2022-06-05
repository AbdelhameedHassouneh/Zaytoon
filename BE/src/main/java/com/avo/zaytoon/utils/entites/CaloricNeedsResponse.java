package com.avo.zaytoon.utils.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CaloricNeedsResponse implements  ServiceEntity{
    @JsonProperty("caloric_needs")
    private double caloric_needs;
}
