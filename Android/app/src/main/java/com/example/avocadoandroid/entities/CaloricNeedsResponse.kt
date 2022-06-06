package com.example.avocadoandroid.entities

import com.google.gson.annotations.SerializedName

data class CaloricNeedsResponse(@SerializedName("caloric_needs") val caloricNeeds: Double)