package com.example.movieapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieapp.data.Movie
import com.example.movieapp.ui.screens.components.MainScreenBody

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    data: List<Movie>
) {
    Surface() {
        Scaffold (
            topBar = {},
            bottomBar = {}
        ) {
            Surface(
                modifier = modifier.padding(it)
            ) {
                MainScreenBody(
                    navController = navController,
                    movies = data
                )
            }
        }
    }
}