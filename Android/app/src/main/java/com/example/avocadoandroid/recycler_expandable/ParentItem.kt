package com.example.avocadoandroid.recycler_expandable

import com.google.gson.annotations.SerializedName

data class ParentItem(
    @SerializedName("category_items") val categoryItems: List<ChildItem>,
    @SerializedName("category") val category: String
)