package com.alimamdouh.domain.repo

import com.alimamdouh.domain.entity.CategoriesResponse

interface MealsRepo {
    suspend fun getMealsFromRemote(): CategoriesResponse
}