package com.example.avocadoandroid.di.apis

import com.example.avocadoandroid.entities.*
import com.example.avocadoandroid.recycler_expandable.ChildItem
import com.example.avocadoandroid.recycler_expandable.ParentItem
import com.example.avocadoandroid.utils.Da
import com.example.avocadoandroid.utils.FinalItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*


interface UserApi {

    @POST("login")
    fun login(@Body user:User): Observable<User>

    @POST("signup")
    fun signUp(@Body user:User):Observable<User>

    @PUT("edit")
    fun editProfile(@Body user:User):Observable<User>

    @POST("caloric_needs")
    fun calcualteCaloricNeeds(@Body caloriesDTO: CaloriesDTO):Observable<CaloricNeedsResponse>

    @POST("categories")
    fun getCategories(@Body dto:CategoryDto):Observable<CategoriesResponse>

    @POST("categories_items")
    fun getCategoryItems(@Body dto:CategoryDto ):Observable<List<ChildItem>>

    @POST("categories_items_aggregated")
    fun getCategoriesItemsAggregated(@Body dto: CategoryDto):Observable<Da>


    @POST("items")
    fun getFinalItem(@Body finalDto: FinalDto):Observable<FinalItem>
}