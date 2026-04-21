package com.example.nutrion_ed_android.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalorieViewModel : ViewModel() {

    var calorieGoal = mutableStateOf(2000)
        private set

    var proteinGoal = mutableStateOf(150)
        private set

    var carbsGoal = mutableStateOf(250)
        private set

    var fatGoal = mutableStateOf(70)
        private set

    fun increaseGoal() {
        calorieGoal.value += 100
    }

    fun setCalorieGoal(newGoal: Int) {
        calorieGoal.value = newGoal
    }

    fun setProteinGoal(newGoal: Int) {
        proteinGoal.value = newGoal
    }

    fun setCarbsGoal(newGoal: Int) {
        carbsGoal.value = newGoal
    }

    fun setFatGoal(newGoal: Int) {
        fatGoal.value = newGoal
    }
}