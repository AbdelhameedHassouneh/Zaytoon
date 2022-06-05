package com.avo.zaytoon.repositories;

import com.avo.zaytoon.utils.entites.FoodItemsInterface;
import com.avo.zaytoon.utils.models.FoodItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends CrudRepository<FoodItem,Long>  {

    @Query(value = "SELECT DISTINCT f.food_section FROM food_item f where zayton_section = :zaytonSection ",nativeQuery = true)
    List<String> getCategories(@Param("zaytonSection") String zaytonSection );

    @Query(value = "select distinct  food_section as foodSection, picture_name as pictureName,sub_title as subTitle," +
            "side_notes as sideNotes,food_item as foodItem,zayton_section as zaytonSection from food_item where " +
            "zayton_section=:zaytonSection and food_section =:foodSection ",nativeQuery = true)
    List<FoodItemsInterface> getFoodItemsBySectionAndCategory(@Param("zaytonSection") String zaytonSection, @Param("foodSection") String foodSection );

    List<FoodItem> findAllByFoodItemName( String itemName );

    List<FoodItem> findAllByZaytonSection( String zaytonSection );



}
