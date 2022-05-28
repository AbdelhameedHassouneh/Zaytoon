package com.example.avocadoandroid.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avocadoandroid.entities.User

class UserSharedViewModel:ViewModel() {
    private val _userLiveData = MutableLiveData<User>()
    val userLiveData:LiveData<User> get() = _userLiveData

    fun setUser(user:User){
        _userLiveData.postValue(user)
    }
}