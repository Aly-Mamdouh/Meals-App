package com.alimamdouh.data.remote

import com.alimamdouh.domain.entity.CategoriesResponse
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getMeals():CategoriesResponse
}