package com.example.avocadoandroid.di.apis

import com.example.avocadoandroid.entities.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface UserApi {

    @POST("login")
    fun login(@Body user:User): Call<User>
}