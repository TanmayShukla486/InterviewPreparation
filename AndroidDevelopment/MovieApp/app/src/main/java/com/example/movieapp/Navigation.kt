package com.example.movieapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.ui.screens.MainScreen
import com.example.movieapp.ui.screens.MovieScreen
import com.example.movieapp.ui.screens.components.MovieScreenBody

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main-screen") {
        composable("splash-screen") {

        }
        composable("main-screen") {
            MovieScreen(
                navController = navController
            )
        }
        composable("movie-screen") {

        }
    }
}