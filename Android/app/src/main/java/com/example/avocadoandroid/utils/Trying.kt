package com.example.avocadoandroid.utils

data class Da(
    val `data`: List<Data>
)

data class Data(
    val category: String,
    val category_items: List<CategoryItem>
)

data class CategoryItem(
    val foodItem: String,
    val foodSection: String,
    val pictureName: String,
    val sideNotes: String,
    val subTitle: String,
    val zaytonSection: String
)