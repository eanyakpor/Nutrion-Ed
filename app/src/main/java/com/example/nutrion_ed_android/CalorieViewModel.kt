package com.example.nutrion_ed_android.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalorieViewModel : ViewModel() {

    var calorieGoal = mutableStateOf(2000)
        private set

    fun increaseGoal() {
        calorieGoal.value += 100
    }
}

