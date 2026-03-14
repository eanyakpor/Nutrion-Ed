package com.example.nutrion_ed_android.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.nutrion_ed_android.model.Meal

class MealViewModel : ViewModel() {

    val meals = mutableStateListOf<Meal>()

    fun addMeal(meal: Meal) {
        meals.add(meal)
    }

    fun totalCalories(): Int {
        return meals.sumOf { it.calories }
    }
}