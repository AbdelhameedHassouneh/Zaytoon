package com.example.avocadoandroid.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avocadoandroid.SingleLiveEvent
import com.example.avocadoandroid.di.managers.UserManager
import com.example.avocadoandroid.entities.*
import com.example.avocadoandroid.recycler_expandable.ChildItem
import com.example.avocadoandroid.recycler_expandable.ParentItem
import com.example.avocadoandroid.utils.Da
import com.example.avocadoandroid.utils.FinalItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UserSharedViewModel : ViewModel() {
    @Inject
    lateinit var userManager: UserManager

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> get() = _userLiveData

    private val _userToEditLiveData = MutableLiveData<User>()
    val userToEditLiveData: LiveData<User> get() = _userToEditLiveData

    private val _caloricNeeds = SingleLiveEvent<Double>()
    val caloricNeeds: LiveData<Double> get() = _caloricNeeds

    private val _zaytoonCat = MutableLiveData<String>()
    val zaytoonCat: LiveData<String> get() = _zaytoonCat

    private val _aggregatedItems = MutableLiveData<Da>()
    val aggregatedItems :LiveData<Da> get() = _aggregatedItems

    private val _finalItemLiveData = MutableLiveData<String>()
    val finalItemLiveData:LiveData<String> get() = _finalItemLiveData

    private val _finalFinalLiveData = MutableLiveData<FinalItem>()
    val finalFinalLiveData:LiveData<FinalItem> get() = _finalFinalLiveData

    fun setUser(user: User) {
        _userLiveData.postValue(user)
    }

    fun setUserToEdit(user: User) {
        _userToEditLiveData.postValue(user)
    }

    fun setZaytoonCat(str: String) {
        _zaytoonCat.postValue(str)
    }

    fun setFinalItem(str:String){
        _finalItemLiveData.postValue(str)
    }

    fun editProfile(userToEdit: User) {
        val observable: Observable<User> =
            userManager.editProfile(userToEdit).subscribeOn(Schedulers.io())
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

    companion object {
        private const val TAG = "UserSharedViewModel"
    }

    fun calculateNeeds(dto: CaloriesDTO) {

        val observable: Observable<CaloricNeedsResponse> =
            userManager.calculateNeeds(dto).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        val observer: Observer<CaloricNeedsResponse> = object : Observer<CaloricNeedsResponse> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onNext(t: CaloricNeedsResponse) {
                Log.d(TAG, "onNext in the sign up: $t")
                _caloricNeeds.postValue(t.caloricNeeds)
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: $e")
            }

            override fun onComplete() {
            }
        }
        observable.subscribe(observer)
    }

    fun getCategoriesAggregated(dto:CategoryDto){
        val observable: Observable<Da> =
            userManager.getCategoriesItemsAggregated(dto).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        val observer: Observer<Da> = object : Observer<Da> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onNext(t: Da) {
                Log.d(TAG, "onNext in the sign up: $t")
                _aggregatedItems.postValue(t)
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: $e")
            }

            override fun onComplete() {
            }
        }
        observable.subscribe(observer)
    }

    fun getLastItem(dto:FinalDto){
        val observable: Observable<FinalItem> =
            userManager.getFinalItem(dto).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        val observer: Observer<FinalItem> = object : Observer<FinalItem> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onNext(t: FinalItem) {
                Log.d(TAG, "onNext in the sign up: $t")
                _finalFinalLiveData.postValue(t)
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