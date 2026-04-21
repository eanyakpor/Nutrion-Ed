package com.example.nutrion_ed_android

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nutrion_ed_android.model.Meal
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MealPager(
    meals: List<Meal>
) {
    val sortedMeals = meals.sortedByDescending { it.time }
    val mealPages = sortedMeals.chunked(2)

    if (mealPages.isEmpty()) {
        Text("No meals added yet.")
        return
    }

    val pagerState = rememberPagerState(pageCount = { mealPages.size })

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Recent Meals")

        Spacer(modifier = Modifier.height(12.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                mealPages[page].forEach { meal ->
                    MealCard(meal = meal)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Page ${pagerState.currentPage + 1} of ${mealPages.size}")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MealCard(
    meal: Meal
) {
    val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.width(110.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text("Kcal: ${meal.calories}")
                Text("P: ${meal.protein}")
                Text("C: ${meal.carbs}")
                Text("F: ${meal.fat}")
            }

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(meal.name)
                Text(meal.time.format(timeFormatter))
            }
        }
    }
}