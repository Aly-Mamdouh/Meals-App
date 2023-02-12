package com.alimamdouh.domain.usecase

import com.alimamdouh.domain.repo.MealsRepo

class GetMeals(private val mealsRepo: MealsRepo) {
    suspend operator fun invoke() = mealsRepo.getMealsFromRemote()
}