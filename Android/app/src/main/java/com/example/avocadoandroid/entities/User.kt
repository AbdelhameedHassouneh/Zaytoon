package com.example.avocadoandroid.entities

import com.google.gson.annotations.SerializedName

data class User (val id:Long,
                 @SerializedName("first_name")val firstName:String,
                 @SerializedName("last_name") val lastName:String,
                 val weight:Double,
                 val height:Double,
                 val email:String,
                 val phone:String,
                 val password:String
                 ){


    constructor(email:String,password: String):this(0,"","",0.0,0.0,email,"",password)
}