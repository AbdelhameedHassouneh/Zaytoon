package com.example.avocadoandroid.di.excutors

import com.example.avocadoandroid.di.apis.UserApi
import com.example.avocadoandroid.entities.*
import com.example.avocadoandroid.recycler_expandable.ChildItem
import com.example.avocadoandroid.recycler_expandable.ParentItem
import com.example.avocadoandroid.utils.Da
import com.example.avocadoandroid.utils.FinalItem
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class UserApiExcutor @Inject constructor(val okHttpClient: OkHttpClient){

    val gson = GsonBuilder().serializeNulls().create()
    private var retrofit: Retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson)).
    addCallAdapterFactory(RxJava3CallAdapterFactory.create()).
    client(okHttpClient).baseUrl("http://10.0.2.2:8080/").build()

    fun login(userToCheck: User): Observable<User> {
        val api = retrofit.create(UserApi::class.java)
        return api.login(userToCheck)
    }

    fun signUp(userToSignUp:User):Observable<User>{
        val api = retrofit.create(UserApi::class.java)
        return api.signUp(userToSignUp)
    }

    fun edit(userToEdit:User):Observable<User>{
        val api = retrofit.create(UserApi::class.java)
        return api.editProfile(userToEdit)
    }

    fun calculateNeeds(caloriesDTO: CaloriesDTO):Observable<CaloricNeedsResponse>{
        val api = retrofit.create(UserApi::class.java)
        return api.calcualteCaloricNeeds(caloriesDTO)
    }

    fun getCategories(instance:CategoryDto):Observable<CategoriesResponse>{
        val api = retrofit.create(UserApi::class.java)
        return api.getCategories(instance)
    }

    fun getCategoryItems(instance:CategoryDto):Observable<List<ChildItem>>{
        val api = retrofit.create(UserApi::class.java)
        return api.getCategoryItems(instance)
    }

    fun getCategoriesItemsAggregated(instance:CategoryDto):Observable<Da>{
        val api = retrofit.create(UserApi::class.java)
        return api.getCategoriesItemsAggregated(instance)
    }

    fun getFinalItem(finalDto: FinalDto):Observable<FinalItem>{
        val api = retrofit.create(UserApi::class.java)
        return api.getFinalItem(finalDto)
    }

}