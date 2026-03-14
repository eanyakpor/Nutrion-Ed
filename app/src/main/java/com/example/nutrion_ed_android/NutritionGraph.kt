package com.example.nutrion_ed_android

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomChart(
    barValue: List<Float>,
    xAxisScale: List<String>,
    totalAmount: Int
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
                color = Color.Blue,
                topLeft = Offset(xStart, yStart),
                size = androidx.compose.ui.geometry.Size(barWidth, barHeight)
            )
        }
    }
}