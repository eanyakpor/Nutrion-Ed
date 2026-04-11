package com.example.nutrion_ed_android

import androidx.compose.foundation.Image
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.ui.tooling.preview.Preview



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodDetailScreen(
    onBack: () -> Unit
) {

    var foodName by remember { mutableStateOf("Watermelon") }

    var servingsEaten by remember { mutableStateOf("2") }
    var servingSize by remember { mutableStateOf("150 g") }

    var eatenCalories by remember { mutableStateOf("200") }
    var eatenCarbs by remember { mutableStateOf("52") }
    var eatenProtein by remember { mutableStateOf("280") }
    var eatenSodium by remember { mutableStateOf("10") }

    var servingCalories by remember { mutableStateOf("100") }
    var servingCarbs by remember { mutableStateOf("26") }
    var servingProtein by remember { mutableStateOf("140") }
    var servingSodium by remember { mutableStateOf("5") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = foodName,
                onValueChange = { foodName = it },
                label = { Text("Food Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

//            Image(
//                painter = painterResource(id = R.drawable.watermelon),
//                contentDescription = "Food Image",
//                modifier = Modifier
//                    .size(110.dp)
//                    .clip(RoundedCornerShape(10.dp)),
//                contentScale = ContentScale.Crop
//            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                EditableMacroColumn(
                    modifier = Modifier.weight(1f),
                    title = "Srvg Eaten",
                    titleValue = servingsEaten,
                    onTitleValueChange = { servingsEaten = it },
                    calories = eatenCalories,
                    onCaloriesChange = { eatenCalories = it },
                    carbs = eatenCarbs,
                    onCarbsChange = { eatenCarbs = it },
                    protein = eatenProtein,
                    onProteinChange = { eatenProtein = it },
                    sodium = eatenSodium,
                    onSodiumChange = { eatenSodium = it }
                )

                EditableMacroColumn(
                    modifier = Modifier.weight(1f),
                    title = "Srvg Size",
                    titleValue = servingSize,
                    onTitleValueChange = { servingSize = it },
                    calories = servingCalories,
                    onCaloriesChange = { servingCalories = it },
                    carbs = servingCarbs,
                    onCarbsChange = { servingCarbs = it },
                    protein = servingProtein,
                    onProteinChange = { servingProtein = it },
                    sodium = servingSodium,
                    onSodiumChange = { servingSodium = it }
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Effect On Goals",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                GoalCircleCard("77%", Color(0xFF4A86E8))
                GoalCircleCard("29%", Color(0xFFF4D03F))
                GoalCircleCard("29%", Color(0xFFF5B7B1))
                GoalCircleCard("29%", Color(0xFFA9F5A9))
            }

            Spacer(modifier = Modifier.height(18.dp))

          Divider(
                modifier = Modifier.width(90.dp),
                thickness = 2.dp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Nutrition",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(14.dp))

           // NutritionSection()

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    // Save the manually entered food data here
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Food")
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableMacroColumn(
    modifier: Modifier = Modifier,
    title: String,
    titleValue: String,
    onTitleValueChange: (String) -> Unit,
    calories: String,
    onCaloriesChange: (String) -> Unit,
    carbs: String,
    onCarbsChange: (String) -> Unit,
    protein: String,
    onProteinChange: (String) -> Unit,
    sodium: String,
    onSodiumChange: (String) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = titleValue,
            onValueChange = onTitleValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        MacroInputField(
            label = "Calories",
            value = calories,
            onValueChange = onCaloriesChange,
            textColor = Color(0xFF4A86E8)
        )

        MacroInputField(
            label = "Carbs",
            value = carbs,
            onValueChange = onCarbsChange,
            textColor = Color(0xFFF4C542)
        )

        MacroInputField(
            label = "Protein",
            value = protein,
            onValueChange = onProteinChange,
            textColor = Color.Red
        )

        MacroInputField(
            label = "Sodium",
            value = sodium,
            onValueChange = onSodiumChange,
            textColor = Color(0xFF34A853)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MacroInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    textColor: Color
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            color = textColor,
            style = MaterialTheme.typography.bodySmall
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(6.dp))
    }
}

@Composable
fun GoalCircleCard(
    percent: String,
    ringColor: Color
) {
    Card(
        modifier = Modifier.size(68.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .border(5.dp, ringColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = percent,
                    color = ringColor,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FoodDetailScreenPreview() {
    FoodDetailScreen(
        onBack = {}
    )
}