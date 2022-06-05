package com.avo.zaytoon.utils.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CategoryFoodItemResponse {
    @JsonProperty(value = "categories")
    List<FoodItemBo>  foodItemsList;
}
