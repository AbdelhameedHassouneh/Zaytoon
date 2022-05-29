package com.avo.avocado.services;

import com.avo.avocado.repositories.FoodItemRepository;
import com.avo.avocado.utils.entites.*;
import com.avo.avocado.utils.models.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public ResponseEntity<CategoriesResponse> getCategories(String zaytonSection) {
        List<String> res =  new ArrayList<>();
        res = foodItemRepository.getCategories(zaytonSection);
        CategoriesResponse categories = new CategoriesResponse();
        categories.setCategories(res);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    public ResponseEntity<CategoryFoodItemResponse> getFoodItemsByCategoryAndSection(String zaytonSection, String categoryName) {
        CategoryFoodItemResponse categoryFoodItemResponse = new CategoryFoodItemResponse();
        List<FoodItemsInterface> res =  foodItemRepository.getFoodItemsBySectionAndCategory(zaytonSection,categoryName);

        List<FoodItemBo> foodItemBos = new ArrayList<>();
        res.forEach(record->{
            FoodItemBo foodItemBo = new FoodItemBo();
            foodItemBo.setFoodItem(record.getFoodItem());
            foodItemBo.setFoodSection(record.getFoodSection());
            foodItemBo.setZaytonSection(record.getZaytonSection());
            foodItemBo.setPictureName(record.getPictureName());
            foodItemBo.setSideNotes(record.getSideNotes());
            foodItemBo.setSubTitle(record.getSubTitle());
            foodItemBos.add(foodItemBo);
        });
        categoryFoodItemResponse.setFoodItemsList(foodItemBos);

        return new ResponseEntity<>(categoryFoodItemResponse, HttpStatus.OK);
    }
}
