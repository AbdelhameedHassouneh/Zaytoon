package com.avo.avocado.utils.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "food_item")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fats")
    private String fats;

    @Column(name = "carbs")
    private String carbs;

    @Column(name = "calories")
    private String calories;

    @Column(name = "protein")
    private String protein;

    @Column(name = "food_section")
    private String food_section;

    @Column(name = "picture_name")
    private String picture_name;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "food_size")
    private String food_size;

    @Column(name = "side_notes")
    private String side_notes;

    @Column(name = "food_item")
    private String food_item;

    @Column(name = "sub_title")
    private String sub_title;

    @Column(name = "zayton_section")
    private String zaytonSection;

}
