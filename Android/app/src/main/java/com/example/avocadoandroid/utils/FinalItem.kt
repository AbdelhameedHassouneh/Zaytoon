package com.example.avocadoandroid.utils

data class FinalItem(
    val food_item_name: String,
    val food_section: String,
    val picture_name: String,
    val section_name: String,
    val side_note: String,
    val sizes_info: List<SizesInfo>,
    val sub_title: String
)

data class SizesInfo(
    val calories: String,
    val carbs: String,
    val fats: String,
    val food_size: String,
    val protein: String,
    val quantity: String
)