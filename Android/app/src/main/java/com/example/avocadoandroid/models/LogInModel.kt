package com.example.avocadoandroid.models

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avocadoandroid.di.managers.UserManager
import com.example.avocadoandroid.entities.User
import javax.inject.Inject
import com.example.avocadoandroid.MyApplication

private const val TAG = "WWWW"
class LogInModel():ViewModel() {

    @Inject
    lateinit var userManager:UserManager
    private val _user = MutableLiveData<User>()
    val user:LiveData<User> get() = user

    fun loginButton ( email:String, password:String){
        val userToCheck:User = User(email,password)
        Log.d(TAG, "loginButton: $userToCheck")
        val u = userManager.login(userToCheck)
        Log.d(TAG, "loginButton: $u")
    }

}