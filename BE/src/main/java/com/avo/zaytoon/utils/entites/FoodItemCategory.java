package com.avo.zaytoon.utils.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FoodItemCategory {
    @JsonProperty(value = "category_items")
    List<FoodItemBo> foodItemsList;

    @JsonProperty(value = "category")
    private String category;
}
