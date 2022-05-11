package com.example.avocadoandroid.di

import com.example.avocadoandroid.SignUpActivity
import com.example.avocadoandroid.models.LogInModel
import com.example.avocadoandroid.models.SignUpModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetrofitComponent {

    fun inject (logInModel: LogInModel)

    fun inject(signUpModel: SignUpModel)
}