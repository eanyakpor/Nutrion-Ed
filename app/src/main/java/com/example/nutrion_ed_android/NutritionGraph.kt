package com.example.nutrion_ed_android

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NutritionGraph(
    barValue: List<Float>,
    xAxisScale: List<String>,
    totalAmount: Int,
    barColor: Color
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            if (barValue.isEmpty() || totalAmount == 0) return@Canvas

            val barWidth = canvasWidth / (barValue.size * 2)

            barValue.forEachIndexed { index, value ->
                val barHeight = (value / totalAmount) * canvasHeight
                val xStart = index * barWidth * 2 + barWidth / 2
                val yStart = canvasHeight - barHeight

                drawRect(
                    color = barColor,
                    topLeft = Offset(xStart, yStart),
                    size = androidx.compose.ui.geometry.Size(barWidth, barHeight)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            xAxisScale.forEach { label ->
                Text(text = label)
            }
        }
    }
}
