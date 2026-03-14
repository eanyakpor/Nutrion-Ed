package com.example.nutrion_ed_android.model

import java.time.LocalDateTime

data class Meal(
    val name: String,
    val calories: Int,
    val protein: Int,
    val carbs: Int,
    val fat: Int,
    val time: LocalDateTime
)