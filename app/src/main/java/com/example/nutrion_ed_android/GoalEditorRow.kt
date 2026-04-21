package com.example.nutrion_ed_android

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalEditorRow(
    calorieGoal: Int,
    proteinGoal: Int,
    carbsGoal: Int,
    fatGoal: Int,
    onCalorieGoalChange: (Int) -> Unit,
    onProteinGoalChange: (Int) -> Unit,
    onCarbsGoalChange: (Int) -> Unit,
    onFatGoalChange: (Int) -> Unit
) {
    var calorieText by remember { mutableStateOf(calorieGoal.toString()) }
    var proteinText by remember { mutableStateOf(proteinGoal.toString()) }
    var carbsText by remember { mutableStateOf(carbsGoal.toString()) }
    var fatText by remember { mutableStateOf(fatGoal.toString()) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Calories")
            Text("Protein")
            Text("Carbs")
            Text("Fat")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                value = calorieText,
                onValueChange = {
                    calorieText = it
                    it.toIntOrNull()?.let(onCalorieGoalChange)
                },
                modifier = Modifier.width(90.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = proteinText,
                onValueChange = {
                    proteinText = it
                    it.toIntOrNull()?.let(onProteinGoalChange)
                },
                modifier = Modifier.width(90.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = carbsText,
                onValueChange = {
                    carbsText = it
                    it.toIntOrNull()?.let(onCarbsGoalChange)
                },
                modifier = Modifier.width(90.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = fatText,
                onValueChange = {
                    fatText = it
                    it.toIntOrNull()?.let(onFatGoalChange)
                },
                modifier = Modifier.width(90.dp),
                singleLine = true
            )
        }
    }
}