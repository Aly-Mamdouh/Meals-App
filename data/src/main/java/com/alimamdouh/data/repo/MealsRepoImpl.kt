package com.alimamdouh.data.repo

import com.alimamdouh.data.remote.ApiService
import com.alimamdouh.domain.entity.CategoriesResponse
import com.alimamdouh.domain.repo.MealsRepo

class MealsRepoImpl(private val apiService: ApiService) : MealsRepo {
    override suspend fun getMealsFromRemote(): CategoriesResponse = apiService.getMeals()
}