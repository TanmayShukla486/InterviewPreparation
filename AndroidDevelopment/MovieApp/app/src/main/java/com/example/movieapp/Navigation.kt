package com.example.movieapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.ui.screens.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main-screen") {
        composable("splash-screen") {

        }
        composable("main-screen") {
            MainScreen(navController = navController, data = emptyList())
        }
        composable("movie-screen") {

        }
    }
}