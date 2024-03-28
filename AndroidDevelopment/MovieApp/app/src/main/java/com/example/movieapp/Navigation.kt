package com.example.movieapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash-screen") {
        composable("splash-screen") {

        }
        composable("main-screen") {

        }
        composable("movie-screen") {

        }
    }
}