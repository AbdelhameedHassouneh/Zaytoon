package com.example.avocadoandroid

import android.app.Application
import com.example.avocadoandroid.di.DaggerRetrofitComponent
import com.example.avocadoandroid.di.RetrofitComponent

class MyApplication: Application() {

    private lateinit var retrofitComponent: RetrofitComponent
    override fun onCreate() {
        super.onCreate()
        retrofitComponent = DaggerRetrofitComponent.create()
    }

    fun getComponent():RetrofitComponent{
        return retrofitComponent
    }
}