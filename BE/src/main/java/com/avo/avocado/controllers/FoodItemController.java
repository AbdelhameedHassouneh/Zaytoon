package com.avo.avocado.controllers;

import com.avo.avocado.services.FoodItemService;
import com.avo.avocado.utils.dtos.CategoryDTO;
import com.avo.avocado.utils.dtos.ItemsDTO;
import com.avo.avocado.utils.entites.CategoriesResponse;
import com.avo.avocado.utils.entites.CategoryFoodItemResponse;
import com.avo.avocado.utils.entites.FoodItemResponse;
import com.avo.avocado.utils.models.FoodItem;
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
}
