package com.example.avocadoandroid.di.managers

import android.database.Observable
import com.example.avocadoandroid.di.excutors.UserApiExcutor
import com.example.avocadoandroid.entities.*
import com.example.avocadoandroid.recycler_expandable.ChildItem
import com.example.avocadoandroid.recycler_expandable.ParentItem
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

    fun calculateNeeds(dto: CaloriesDTO):io.reactivex.rxjava3.core.Observable<CaloricNeedsResponse>{
        return excutor.calculateNeeds(dto)
    }

    fun getCategories(dto:CategoryDto):io.reactivex.rxjava3.core.Observable<CategoriesResponse>{
        return excutor.getCategories(dto)
    }

    fun getCategoryItems(dto:CategoryDto):io.reactivex.rxjava3.core.Observable<List<ChildItem>>{
        return excutor.getCategoryItems(dto)
    }

    fun getCategoriesItemsAggregated(instance:CategoryDto): io.reactivex.rxjava3.core.Observable<List<ParentItem>> {
        return excutor.getCategoriesItemsAggregated(instance)
    }
}