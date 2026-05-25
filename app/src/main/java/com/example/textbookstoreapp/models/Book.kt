package com.example.textbookstoreapp.models

data class Book(
    val title: String,
    val author: String,
    val edition: String,
    val price: String,
    val description: String,
    val imageResId: Int
)