package com.alimamdouh.mealzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.alimamdouh.mealzapp.databinding.ActivityMainBinding
import com.alimamdouh.mealzapp.viewModel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model:MealsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter=CategoryAdapter()
        model.getMeals()
        lifecycleScope.launch{
            model.categories.collect{
                adapter.submitList(it?.categories)
                binding.catRv.adapter=adapter
            }
        }
    }
}