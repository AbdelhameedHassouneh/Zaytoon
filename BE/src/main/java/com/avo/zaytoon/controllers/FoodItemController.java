package com.avo.zaytoon.controllers;

import com.avo.zaytoon.services.FoodItemService;
import com.avo.zaytoon.utils.dtos.CategoryDTO;
import com.avo.zaytoon.utils.dtos.ItemsDTO;
import com.avo.zaytoon.utils.entites.CategoriesResponse;
import com.avo.zaytoon.utils.entites.CategoryFoodItemResponse;
import com.avo.zaytoon.utils.entites.CategoryFoodItemsAggregatedResponse;
import com.avo.zaytoon.utils.entites.FoodItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("categories")
    public ResponseEntity<CategoriesResponse> getCategories(@RequestBody CategoryDTO zaytonSection)  {
        return foodItemService.getCategories(zaytonSection.getZaytonSection());
    }

    @PostMapping("categories_items")
    public ResponseEntity<CategoryFoodItemResponse> getCategoriesItems(@RequestBody CategoryDTO zaytonSection)  {
        return foodItemService.getFoodItemsByCategoryAndSection(zaytonSection.getZaytonSection(), zaytonSection.getCategory_name());
    }

    @PostMapping("items")
    public ResponseEntity<FoodItemResponse> getItems(@RequestBody ItemsDTO itemsDTO)  {
        return foodItemService.getFoodItemsByName(itemsDTO.getItem_name());
    }

    @PostMapping("categories_items_aggregated")
    public ResponseEntity<CategoryFoodItemsAggregatedResponse> getCategoriesItemsAggregated(@RequestBody CategoryDTO zaytonSection)  {
        return foodItemService.getFoodItemsByCategoryAndSectionAggregated(zaytonSection.getZaytonSection(), zaytonSection.getCategory_name());
    }
}
