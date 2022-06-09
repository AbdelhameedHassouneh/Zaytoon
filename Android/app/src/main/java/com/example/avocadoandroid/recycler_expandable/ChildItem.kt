package com.example.avocadoandroid.recycler_expandable

import com.google.gson.annotations.SerializedName

data class ChildItem (@SerializedName("pictureName")val pictureName:String,
                      @SerializedName("SideNotes") val sideNotes:String,
                      @SerializedName("subTitle")val subTitle:String,
                      @SerializedName("foodItem") val foodItem:String,
                        @SerializedName("foodSection")val foodSections:String)