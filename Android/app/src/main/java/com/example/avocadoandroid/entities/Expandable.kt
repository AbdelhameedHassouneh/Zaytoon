package com.example.avocadoandroid.entities

import com.example.avocadoandroid.recycler_expandable.ChildItem
import com.example.avocadoandroid.recycler_expandable.ParentItem
import com.google.gson.annotations.SerializedName

data class Expandable (@SerializedName("data")val list:List<ParentItem>)