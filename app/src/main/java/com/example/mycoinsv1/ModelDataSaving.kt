package com.example.mycoinsv1

data class Saving(
    val title: String,
    val description: String,
    val target: Int,
    var collectedAmount: Int = 0
)