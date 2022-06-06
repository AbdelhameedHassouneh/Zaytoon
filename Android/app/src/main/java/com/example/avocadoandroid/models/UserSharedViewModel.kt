package com.example.avocadoandroid.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avocadoandroid.SingleLiveEvent
import com.example.avocadoandroid.di.managers.UserManager
import com.example.avocadoandroid.entities.*
import com.example.avocadoandroid.recycler_expandable.ChildItem
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

    private val _caloricNeeds = SingleLiveEvent<Double>()
    val caloricNeeds :LiveData<Double> get() = _caloricNeeds

    val _zaytoonCat = MutableLiveData<String>()
    val zaytoonCat:LiveData<String> get() = _zaytoonCat


    private val _categoriesLiveData = MutableLiveData<List<String>>()
    val categoriesLiveData:LiveData<List<String>> get() = _categoriesLiveData

    private val _drinksLiveData = MutableLiveData<List<ChildItem>>()
    val drinksLiveData:LiveData<List<ChildItem>> get() = _drinksLiveData

    private val _sandwichesLiveData = MutableLiveData<List<ChildItem>>()
    val sandwichesLiveData:LiveData<List<ChildItem>> get() = _sandwichesLiveData

    private val _bakeriesLiveData = MutableLiveData<List<ChildItem>>()
    val bakeriesLiveData:LiveData<List<ChildItem>> get() = _bakeriesLiveData


    private val _sweetsLiveData = MutableLiveData<List<ChildItem>>()
    val sweetLiveData:LiveData<List<ChildItem>> get() = _sweetsLiveData

    private val _streetSnacksLiveData = MutableLiveData<List<ChildItem>>()
    val streetSnacksLiveData:LiveData<List<ChildItem>> get() = _streetSnacksLiveData

    private val _dealsLiveData = MutableLiveData<List<ChildItem>>()
    val dealsLiveData:LiveData<List<ChildItem>> get() = _dealsLiveData


    private val _toppingsLiveData = MutableLiveData<List<ChildItem>>()
    val toppingsLiveData:LiveData<List<ChildItem>> get() = _toppingsLiveData








    fun setUser(user: User) {
        _userLiveData.postValue(user)
    }
    fun setUserToEdit(user:User){
        _userToEditLiveData.postValue(user)
    }

    fun setZaytoonCat(str:String){
        _zaytoonCat.postValue(str)
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


    fun getCategories(zaytoonCat:String){
        val observable:Observable<CategoriesResponse> = userManager.getCategories(CategoryDto( zaytoonCat))
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

        val observer: Observer<CategoriesResponse> = object : Observer<CategoriesResponse> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onNext(t: CategoriesResponse) {
                Log.d(TAG, "onNext in the sign up: ${t.categories}")
//                _caloricNeeds.postValue(t.caloricNeeds)
                _categoriesLiveData.postValue(t.categories)
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: $e")
            }

            override fun onComplete() {
            }
        }
        observable.subscribe(observer)
    }

    fun getCategoryItems(dto:CategoryDto){
        val observable:Observable<List<ChildItem>> = userManager.getCategoryItems(dto)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

        val observer: Observer<List<ChildItem>> = object : Observer<List<ChildItem>> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")
            }
            override fun onNext(t: List<ChildItem>) {
                if(dto.categoryName == "Drinks"){
                    _drinksLiveData.postValue(t)
                    Log.d(TAG, "onNext: MFFFFF")
                }else if (dto.categoryName == "Street snacks"){
                    _streetSnacksLiveData.postValue(t)
                }else if(dto.categoryName == "Sandwiches"){
                    _sandwichesLiveData.postValue(t)
                }else if(dto.categoryName == "Bakeries"){
                    _bakeriesLiveData.postValue(t)
                }else if(dto.categoryName == "Sweets"){
                    _sweetsLiveData.postValue(t)
                }
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