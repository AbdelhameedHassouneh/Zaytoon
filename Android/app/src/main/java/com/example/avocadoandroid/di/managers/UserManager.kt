package com.example.avocadoandroid.di.managers

import com.example.avocadoandroid.di.excutors.UserApiExcutor
import com.example.avocadoandroid.entities.User
import javax.inject.Inject

class UserManager @Inject constructor(val excutor: UserApiExcutor) {


    fun login(user:User): User?{
        return excutor.login(user, object: ApiCallback<User> {

        })
    }

}