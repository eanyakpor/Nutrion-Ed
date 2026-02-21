package com.example.nutrion_ed_android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nutrion_ed_android.viewmodel.CalorieViewModel

@Composable
fun HomeScreen(viewModel: CalorieViewModel) {

    val goal by viewModel.calorieGoal

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Daily Calorie Goal: $goal")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.increaseGoal()
        }) {
            Text("Increase Goal")
        }
    }
}