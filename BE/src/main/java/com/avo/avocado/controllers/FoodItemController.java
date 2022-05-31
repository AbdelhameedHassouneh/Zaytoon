package com.avo.avocado.controllers;

import com.avo.avocado.services.FoodItemService;
import com.avo.avocado.utils.dtos.CategoryDTO;
import com.avo.avocado.utils.entites.CategoriesResponse;
import com.avo.avocado.utils.entites.CategoryFoodItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("categories")
    public ResponseEntity<CategoriesResponse> getCategories(@RequestBody CategoryDTO zaytonSection)  {
        return foodItemService.getCategories(zaytonSection.getZaytonSection());
    }

    @GetMapping("categories_items")
    public ResponseEntity<CategoryFoodItemResponse> getCategoriesItems(@RequestBody CategoryDTO zaytonSection)  {
        return foodItemService.getFoodItemsByCategoryAndSection(zaytonSection.getZaytonSection(), zaytonSection.getCategory_name());
    }
}
