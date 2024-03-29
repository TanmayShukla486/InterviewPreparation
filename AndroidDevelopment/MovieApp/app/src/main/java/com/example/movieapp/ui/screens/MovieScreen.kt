package com.example.movieapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieapp.data.Movie
import com.example.movieapp.ui.screens.components.MovieScreenBody

@Composable
fun MovieScreen (
    modifier: Modifier = Modifier,
    navController: NavController,
    movie: Movie
) {
    Surface {
        Scaffold (
            topBar = {},
            bottomBar = {}
        ) {
            Surface (
                modifier = modifier.padding(it)
            ) {
                MovieScreenBody(
                    movie = movie
                )
            }
        }
    }
}