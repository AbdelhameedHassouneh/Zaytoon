package com.avo.zaytoon.utils.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FoodItemResponse {

    @JsonProperty(value = "food_section")
    private String foodSection;
    @JsonProperty(value = "picture_name")
    private String pictureName;
    @JsonProperty(value = "section_name")
    private String zaytonSection;
    @JsonProperty(value = "side_note")
    private String sideNotes;
    @JsonProperty(value = "food_item_name")
    private String foodItem;
    @JsonProperty(value = "sub_title")
    private String subTitle;
    @JsonProperty(value = "sizes_info")
    List<FoodItemSize> sizesInfo;

}
