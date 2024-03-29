package com.example.movieapp.data

data class Movie(
    val name: String,
    val desc: String,
    val rating: Float,
    val director: String,
    val writer: String,
    val revenue: Float,
    val thumbnail: String,
    val cast: String,
    val screenshots: List<String>
)
