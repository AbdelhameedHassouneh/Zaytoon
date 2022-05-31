package com.avo.avocado.utils;

import com.avo.avocado.repositories.FoodItemRepository;
import com.avo.avocado.utils.models.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class DataAppenderOnApplicationStartup
        implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        int counter = 0;
        //read from csv file and append to database once the application started
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/main/java/com/avo/avocado/db/sheet1.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Failed to read csv file");
            e.printStackTrace();
        }
        //setting comma as delimiter pattern
        sc.useDelimiter("\r\n");

        // save items to DB
        List<FoodItem> foodItemsList = new ArrayList<>();
        while (sc.hasNext()) {
            counter++;
            String lineOfData = sc.next();
            FoodItem foodItem = new FoodItem();
            String fats  = lineOfData.split(",")[6];
            String carbs =  lineOfData.split(",")[7];
            String calories =  lineOfData.split(",")[8];
            String protein =  lineOfData.split(",")[9];
            String food_section = lineOfData.split(",")[0];
            String picture_name = lineOfData.split(",")[1];;
            String quantity = lineOfData.split(",")[3];
            String food_size = lineOfData.split(",")[4];
            String side_notes  = lineOfData.split(",")[5];
            String food_item  = lineOfData.split(",")[10];
            String sub_title = lineOfData.split(",")[2];

            foodItem.setId(counter);
            foodItem.setFood_item(food_item);
            foodItem.setCalories(calories);
            foodItem.setFats(fats);
            foodItem.setCarbs(carbs);
            foodItem.setPicture_name(picture_name);
            foodItem.setProtein(protein);
            foodItem.setFood_section(food_section);
            foodItem.setQuantity(quantity);
            foodItem.setFood_size(food_size);
            foodItem.setSide_notes(side_notes);
            foodItem.setSub_title(sub_title);
            foodItemsList.add(foodItem);
        }
        //closes the scanner
        sc.close();
        try {
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:42333/backend","backend","backend");
            Statement stmt=con.createStatement();
            foodItemsList.forEach(record->{
                try {
                    String  query = "insert into  food_item values (" +
                            "'"+record.getId()+"'," +
                            "'"+record.getFood_section().trim()+"'," +
                            "'"+record.getPicture_name().trim()+"'," +
                            "\""+record.getSub_title().trim()+"\"," +
                            "'"+record.getQuantity().trim()+"'," +
                            "'"+record.getFood_size().trim()+"'," +
                            "\""+record.getSide_notes().trim()+"\"," +
                             record.getFats().trim()+"," +
                             record.getCarbs().trim()+"," +
                             record.getCalories().trim()+"," +
                             record.getProtein().trim()+"," +
                            "'"+record.getFood_item().trim()+"'," +
                            "'street_food'" +
                            ")";
                    stmt.execute(query);
                } catch (SQLException e) {
                    System.out.println("Failed to Save street food item");
                    e.printStackTrace();
                }
            });
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
}