package com.alimamdouh.mealzapp.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alimamdouh.domain.entity.CategoriesResponse
import com.alimamdouh.domain.usecase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMeals
) : ViewModel() {

    private val _categories: MutableStateFlow<CategoriesResponse?> = MutableStateFlow(null)
    val categories: StateFlow<CategoriesResponse?> = _categories

    fun getMeals() {
        viewModelScope.launch {
            try {
                _categories.value = getMealsUseCase()
            } catch (e: Exception) {
                Log.e("MealsViewModel", e.message.toString())
            }
        }

    }
}