package com.example.nutrion_ed_android

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nutrion_ed_android.model.Meal
import androidx.compose.ui.graphics.Color

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MacroCarousel(
    meals: List<Meal>,
    calorieGoal: Int,
    proteinGoal: Int,
    carbsGoal: Int,
    fatGoal: Int
) {
    val days = listOf(
        "S", "M", "T", "W", "T", "F", "S"
    )

    val CaloriesBlue = Color(0xFF2196F3)
    val ProteinRed = Color(0xFFF44336)
    val FatYellow = Color(0xFFFFC107)
    val CarbsGreen = Color(0xFF4CAF50)

    val caloriesByDay = listOf(
        meals.filter { it.time.dayOfWeek.name == "SUNDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "MONDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "TUESDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "WEDNESDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "THURSDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "FRIDAY" }.sumOf { it.calories }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "SATURDAY" }.sumOf { it.calories }.toFloat()
    )

    val proteinByDay = listOf(
        meals.filter { it.time.dayOfWeek.name == "SUNDAY" }.sumOf { it.protein }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "MONDAY" }.sumOf { it.protein }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "TUESDAY" }.sumOf { it.protein }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "WEDNESDAY" }.sumOf { it.protein }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "THURSDAY" }.sumOf { it.protein }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "FRIDAY" }.sumOf { it.protein }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "SATURDAY" }.sumOf { it.protein }.toFloat()
    )

    val carbsByDay = listOf(
        meals.filter { it.time.dayOfWeek.name == "SUNDAY" }.sumOf { it.carbs }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "MONDAY" }.sumOf { it.carbs }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "TUESDAY" }.sumOf { it.carbs }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "WEDNESDAY" }.sumOf { it.carbs }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "THURSDAY" }.sumOf { it.carbs }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "FRIDAY" }.sumOf { it.carbs }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "SATURDAY" }.sumOf { it.carbs }.toFloat()
    )

    val fatByDay = listOf(
        meals.filter { it.time.dayOfWeek.name == "SUNDAY" }.sumOf { it.fat }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "MONDAY" }.sumOf { it.fat }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "TUESDAY" }.sumOf { it.fat }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "WEDNESDAY" }.sumOf { it.fat }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "THURSDAY" }.sumOf { it.fat }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "FRIDAY" }.sumOf { it.fat }.toFloat(),
        meals.filter { it.time.dayOfWeek.name == "SATURDAY" }.sumOf { it.fat }.toFloat()
    )

    val pageTitles = listOf("Calories", "Protein", "Carbs", "Fat")

    val pageColors: List<Color> = listOf(
        CaloriesBlue,    // Calories
        ProteinRed,     // Protein
        CarbsGreen,  // Carbs
        FatYellow    // Fat
    )

    val pageData = listOf(
        caloriesByDay,
        proteinByDay,
        carbsByDay,
        fatByDay
    )
    val pageMax = listOf(
        calorieGoal,
        proteinGoal,
        carbsGoal,
        fatGoal
    )

    val pagerState = rememberPagerState(pageCount = { pageTitles.size })

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = pageTitles[pagerState.currentPage])
        Spacer(modifier = Modifier.height(12.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            NutritionGraph(
                barValue = pageData[page],
                xAxisScale = days,
                totalAmount = pageMax[page],
                barColor = pageColors[page]
            )
        }
    }
}
