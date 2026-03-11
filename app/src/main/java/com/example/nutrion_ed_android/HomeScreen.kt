package com.example.nutrion_ed_android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nutrion_ed_android.model.Meal
import com.example.nutrion_ed_android.viewmodel.CalorieViewModel
import com.example.nutrion_ed_android.viewmodel.MealViewModel

@Composable
fun HomeScreen(
    calorieViewModel: CalorieViewModel,
    mealViewModel: MealViewModel
) {

    val goal by calorieViewModel.calorieGoal
    val totalCalories = mealViewModel.totalCalories()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Daily Calorie Goal: $goal")

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Calories Consumed: $totalCalories")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            calorieViewModel.increaseGoal()
        }) {
            Text("Increase Goal")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            mealViewModel.addMeal(
                Meal("Apple", 95, 0, 25, 0)
            )
        }) {
            Text("Add Apple")
        }

        Spacer(modifier = Modifier.height(20.dp))

        mealViewModel.meals.forEach { meal ->
            Text("${meal.name} - ${meal.calories} calories")
        }
    }
}