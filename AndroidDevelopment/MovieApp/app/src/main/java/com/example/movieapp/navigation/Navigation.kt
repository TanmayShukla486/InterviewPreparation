package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.data.Movie
import com.example.movieapp.data.getMovies
import com.example.movieapp.ui.screens.MainScreen
import com.example.movieapp.ui.screens.MovieScreen
import com.example.movieapp.ui.screens.SplashScreen
import com.example.movieapp.ui.screens.components.MovieScreenBody

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.SplashScreen.name) {
        composable(MovieScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(MovieScreens.HomeScreen.name) {
            MainScreen(navController = navController, data = getMovies())
        }
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(
                navArgument(
                    name = "movie") {
                    type = NavType.StringType
                })
            ) {
            MovieScreen(
                navController = navController,
                movieName = it.arguments?.getString("movie"),
                moviesList = getMovies()
            )
        }
    }
}