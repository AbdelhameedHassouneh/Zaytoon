package com.example.avocadoandroid.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CaloriesDTO(
    val age: Int,
    val height: Double,
    val weight: Double,
    val gender: String,
    @SerializedName("level_of_activity")
    val levelOfAct: String
):Serializable