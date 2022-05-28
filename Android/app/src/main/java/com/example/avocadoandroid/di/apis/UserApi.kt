package com.example.avocadoandroid.di.apis

import com.example.avocadoandroid.entities.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT


interface UserApi {

    @POST("login")
    fun login(@Body user:User): Observable<User>

    @POST("signup")
    fun signUp(@Body user:User):Observable<User>

    @PUT("edit")
    fun editProfile(@Body user:User):Observable<User>
}