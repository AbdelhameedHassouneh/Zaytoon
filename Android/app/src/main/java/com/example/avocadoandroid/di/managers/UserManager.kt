package com.example.avocadoandroid.di.managers

import android.database.Observable
import com.example.avocadoandroid.di.excutors.UserApiExcutor
import com.example.avocadoandroid.entities.User
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserManager @Inject constructor(val excutor: UserApiExcutor) {


    fun login(user:User): io.reactivex.rxjava3.core.Observable<User> {
        return excutor.login(user)
    }


    fun signUp(user:User):io.reactivex.rxjava3.core.Observable<User>{
        return excutor.signUp(user)
    }

    fun editProfile(user:User): io.reactivex.rxjava3.core.Observable<User> {
        return excutor.edit(user)
    }

}