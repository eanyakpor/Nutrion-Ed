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
    val yLabels = listOf(
        totalAmount,
        (totalAmount * 0.75).toInt(),
        (totalAmount * 0.50).toInt(),
        (totalAmount * 0.25).toInt(),
        0
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(50.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                yLabels.forEach { label ->
                    Text(text = label.toString())
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Canvas(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
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
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(58.dp))

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
}