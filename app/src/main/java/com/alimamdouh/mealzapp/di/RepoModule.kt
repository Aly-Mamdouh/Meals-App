package com.alimamdouh.mealzapp.di

import com.alimamdouh.data.remote.ApiService
import com.alimamdouh.data.repo.MealsRepoImpl
import com.alimamdouh.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): MealsRepo {
        return MealsRepoImpl(apiService)
    }
}