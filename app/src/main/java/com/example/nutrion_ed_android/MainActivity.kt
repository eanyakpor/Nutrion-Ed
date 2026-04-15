package com.example.nutrion_ed_android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
//import androidx.activity.compose.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nutrion_ed_android.viewmodel.CalorieViewModel
import com.example.nutrion_ed_android.viewmodel.MealViewModel
import com.example.nutrion_ed_android.ui.theme.NutrionEdAndroidTheme


class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()

        setContent {
            NutrionEdAndroidTheme {
                val calorieViewModel: CalorieViewModel = viewModel()
                val mealViewModel: MealViewModel = viewModel()

                var currentScreen by remember { mutableStateOf("home") }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (currentScreen) {
                        "home" -> HomeScreen(
                            calorieViewModel = calorieViewModel,
                            mealViewModel = mealViewModel,
                            onOpenFoodDetail = {
                                currentScreen = "foodDetail"
                            }
                        )

                        "foodDetail" -> FoodDetailScreen(
                            onBack = {
                                currentScreen = "home"
                            },
                            calorieViewModel = calorieViewModel,
                            mealViewModel = mealViewModel
                        )
                    }
                }
            }
        }
    }
}