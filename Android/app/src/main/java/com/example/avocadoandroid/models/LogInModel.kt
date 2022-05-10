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
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.math.log

private const val TAG = "WWWW"
class LogInModel():ViewModel() {

    @Inject
    lateinit var userManager:UserManager
    private var _user = MutableLiveData<User>()
    val user:LiveData<User> get() = user

    fun loginButton ( email:String, password:String){
        val userToCheck:User = User(email,password)
        Log.d(TAG, "loginButton: $userToCheck")
        val observable:Observable<User> = userManager.login(userToCheck).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val observer: Observer<User> = object :Observer<User>{
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")
                
            }

            override fun onNext(t: User) {
                Log.d(TAG, "onNext: $t")
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