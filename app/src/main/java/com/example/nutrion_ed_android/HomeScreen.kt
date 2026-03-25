package com.example.nutrion_ed_android.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutrion_ed_android.model.Meal
import com.example.nutrion_ed_android.viewmodel.CalorieViewModel
import com.example.nutrion_ed_android.viewmodel.MealViewModel
import java.time.LocalDateTime
import com.example.nutrion_ed_android.NutritionGraph


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    calorieViewModel: CalorieViewModel,
    mealViewModel: MealViewModel
) {
    val goal by calorieViewModel.calorieGoal
    val totalCalories = mealViewModel.totalCalories()
    val meals = mealViewModel.meals

    val days = listOf(
        "Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday"
    )

    val caloriesByDay = listOf(
        meals.filter { it.time.dayOfWeek.name == "SUNDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "MONDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "TUESDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "WEDNESDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "THURSDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "FRIDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "SATURDAY" }.sumOf { it.calories }.toFloat()
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Daily Calorie Goal: $goal")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Calories Consumed: $totalCalories")
        Spacer(modifier = Modifier.height(20.dp))

        NutritionGraph(
            barValue = caloriesByDay,
            xAxisScale = days,
            totalAmount = goal
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            calorieViewModel.increaseGoal()
        }) {
            Text("Increase Goal")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            mealViewModel.addMeal(
                Meal("Apple", 95, 0, 25, 0, LocalDateTime.now())
            )
        }) {
            Text("Add Apple")
        }

        Spacer(modifier = Modifier.height(20.dp))

        meals.forEach { meal ->
            Text("${meal.name} - ${meal.calories} calories")
        }
    }
}
fun totalCalories() {
    TODO("Not yet implemented")
}

@Composable
fun HomeScreenContent(
    goal: Int,
    totalCalories: Int,
    meals: List<Meal>,
    onIncreaseGoal: () -> Unit,
    onAddApple: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Daily Calorie Goal: $goal")
        Spacer(modifier = Modifier.height(10.dp))
        Text("Calories Consumed: $totalCalories")
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onIncreaseGoal) {
            Text("Increase Goal")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onAddApple) {
            Text("Add Apple")
        }

        Spacer(modifier = Modifier.height(20.dp))

        meals.forEach { meal ->
            Text("${meal.name} - ${meal.calories} calories")
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreenContent(
        goal = 2000,
        totalCalories = 200,
        meals = listOf(
            Meal("Apple", 95, 0, 25, 0, LocalDateTime.now()),
            Meal("Banana", 105, 1, 27, 0, LocalDateTime.now())
        ),
        onIncreaseGoal = {},
        onAddApple = {}
    )
}