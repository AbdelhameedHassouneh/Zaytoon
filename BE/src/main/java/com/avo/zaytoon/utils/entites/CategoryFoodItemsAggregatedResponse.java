package com.avo.zaytoon.utils.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class CategoryFoodItemsAggregatedResponse {
    @JsonProperty(value = "data")
    List<FoodItemCategory> foodItemsList;
}
