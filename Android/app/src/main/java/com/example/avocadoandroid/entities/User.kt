package com.example.avocadoandroid.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    var id: Long,
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var lastName: String,
    var weight: Double,
    var height: Double,
    var email: String,
    var phone: String,
    var password: String,
    var gender: String,
    var age: Int
) : Serializable {


    constructor(email: String, password: String) : this(
        0, "", "", 0.0, 0.0, email, "", password, "FEMALE", 0
    )


    constructor(weight: Double, height: Double, gender: String, age: Int) :
            this(
                0, "", "", weight, height, "",
                "", "", gender, age
            )
    constructor(id:Long,firstName:String,lastName:String,email:String,age:Int,weight:Double,height:Double,gender:String):this(id,firstName,lastName,
                    weight,height,email,"","",gender,age
        )
}
