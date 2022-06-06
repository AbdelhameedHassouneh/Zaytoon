package com.example.avocadoandroid.entities

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    val zaytonSection: String,
    @SerializedName("category_name") val categoryName: String



){
    constructor(zaytonSection: String):this(zaytonSection,"")
}