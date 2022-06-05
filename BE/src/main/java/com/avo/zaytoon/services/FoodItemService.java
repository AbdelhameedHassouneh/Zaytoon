package com.avo.zaytoon.services;

import com.avo.zaytoon.repositories.FoodItemRepository;
import com.avo.zaytoon.utils.entites.*;
import com.avo.zaytoon.utils.models.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ResponseEntity<FoodItemResponse> getFoodItemsByName(String item_name) {
        FoodItemResponse foodItemResponse = new FoodItemResponse();
        List<FoodItem> res =  foodItemRepository.findAllByFoodItemName(item_name);
        foodItemResponse.setFoodItem(res.get(0).getFoodItemName());
        foodItemResponse.setFoodSection(res.get(0).getFood_section());
        foodItemResponse.setPictureName(res.get(0).getPicture_name());
        foodItemResponse.setSideNotes(res.get(0).getSide_notes());
        foodItemResponse.setZaytonSection(res.get(0).getZaytonSection());
        foodItemResponse.setSubTitle(res.get(0).getFoodItemName());
        List<FoodItemSize> foodItemSizes = new ArrayList<>();
        res.stream().forEach(record->{
            FoodItemSize foodItemSize = new FoodItemSize();
            foodItemSize.setFood_size(record.getFood_size());
            foodItemSize.setCalories(record.getCalories());
            foodItemSize.setCarbs(record.getCarbs());
            foodItemSize.setFats(record.getFats());
            foodItemSize.setQuantity(record.getQuantity());
            foodItemSize.setProtein(record.getProtein());
            foodItemSizes.add(foodItemSize);
        });
        foodItemResponse.setSizesInfo(foodItemSizes);
        return new ResponseEntity<>(foodItemResponse, HttpStatus.OK);
    }

    public ResponseEntity<CategoryFoodItemsAggregatedResponse> getFoodItemsByCategoryAndSectionAggregated(String zaytonSection, String category_name) {
        List<FoodItem> bOsList = foodItemRepository.findAllByZaytonSection(zaytonSection);
        Map<String,List<FoodItemBo>> resMap = new HashMap<>();
        bOsList.stream().forEach(record->{
            FoodItemBo foodItemBo = new FoodItemBo();
            foodItemBo.setFoodItem(record.getFoodItemName());
            foodItemBo.setFoodSection(record.getFood_section());
            foodItemBo.setZaytonSection(record.getZaytonSection());
            foodItemBo.setPictureName(record.getPicture_name());
            foodItemBo.setSideNotes(record.getSide_notes());
            foodItemBo.setSubTitle(record.getSub_title());
            if(resMap.get(record.getFood_section())==null){
                List<FoodItemBo> tempList = new ArrayList<>();
                tempList.add(foodItemBo);
                resMap.put(record.getFood_section(),tempList);
            } else{
                List<FoodItemBo> tempList = resMap.get(record.getFood_section());
                tempList.add(foodItemBo);
                resMap.put(record.getFood_section(),tempList);
            }
        });


        List<FoodItemCategory> resList = new ArrayList<>();
        resMap.entrySet().stream().forEach(keyValue->{
            FoodItemCategory foodItemCategory = new FoodItemCategory();
            foodItemCategory.setCategory(keyValue.getKey());
            foodItemCategory.setFoodItemsList(keyValue.getValue());
            resList.add(foodItemCategory);
        });
        CategoryFoodItemsAggregatedResponse response = new CategoryFoodItemsAggregatedResponse();
        response.setFoodItemsList(resList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
