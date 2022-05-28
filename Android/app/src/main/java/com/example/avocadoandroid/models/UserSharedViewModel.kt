package com.example.avocadoandroid.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avocadoandroid.di.managers.UserManager
import com.example.avocadoandroid.entities.User
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UserSharedViewModel : ViewModel() {
    @Inject
    lateinit var userManager:UserManager

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> get() = _userLiveData

    private val _userToEditLiveData = MutableLiveData<User>()
    val userToEditLiveData: LiveData<User> get() = _userToEditLiveData

    fun setUser(user: User) {
        _userLiveData.postValue(user)
    }
    fun setUserToEdit(user:User){
        _userToEditLiveData.postValue(user)
    }

    fun editProfile(userToEdit:User){
        val observable: Observable<User> = userManager.editProfile(userToEdit).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val observer: Observer<User> = object : Observer<User> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")

            }

            override fun onNext(t: User) {
                Log.d(TAG, "onNext in the sign up: $t")
                _userLiveData.postValue(t)
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: $e")
            }

            override fun onComplete() {
            }
        }
        observable.subscribe(observer)
    }
    companion object{
        private const val TAG = "UserSharedViewModel"
    }
}