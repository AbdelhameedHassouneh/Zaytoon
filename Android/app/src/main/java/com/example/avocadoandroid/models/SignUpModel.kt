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

private const val TAG = "SignUpModel"
class SignUpModel: ViewModel() {
    @Inject
    lateinit var userManager: UserManager
    private var _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user


    fun signUp(userToSignUp:User){


        val observable: Observable<User> = userManager.signUp(userToSignUp).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val observer: Observer<User> = object : Observer<User> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")

            }

            override fun onNext(t: User) {
                Log.d(TAG, "onNext in the sign up: $t")
                _user.postValue(t)
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: $e")
            }

            override fun onComplete() {
            }
        }
        observable.subscribe(observer)
    }


}