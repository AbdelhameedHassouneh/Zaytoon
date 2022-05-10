package com.example.avocadoandroid.di.excutors

import com.example.avocadoandroid.di.apis.UserApi
import com.example.avocadoandroid.entities.User
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class UserApiExcutor @Inject constructor(val okHttpClient: OkHttpClient){


    val gson = GsonBuilder().serializeNulls().create()
    private var retrofit: Retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson)).
    addCallAdapterFactory(RxJava3CallAdapterFactory.create()).
    client(okHttpClient).baseUrl("http://10.0.2.2:8080/").build()

//    fun login(user:User, callback: ApiCallback<User>) {
//        val api = retrofit.create(UserApi::class.java)
//        val call = api.login(user)
//        var user:User? = null
//
//        call.enqueue(object :Callback<User>{
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//
//                if(response.isSuccessful){
//                    val user1:User? = response.body()
//                    Log.d("WWWW", "onResponse: $user1")
//                    if(user1!=null){
//                        user = user1
//                            callback.onResponse(user)
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<User>, t: Throwable) {
//            }
//        })
//
////        return user
//    }

    fun login(userToCheck: User): Observable<User> {
        val api = retrofit.create(UserApi::class.java)
        return api.login(userToCheck)

    }
}