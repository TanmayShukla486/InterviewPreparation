package com.example.movieapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.data.Movie
import com.example.movieapp.ui.screens.components.MainScreenBody
import com.example.movieapp.ui.screens.components.MovieScreenBody
import com.example.movieapp.ui.widgets.TopNavBar

@Composable
fun MovieScreen (
    modifier: Modifier = Modifier,
    navController: NavController,
    moviesList: List<Movie>,
    movieName: String? = null
) {
    val movie: Movie? = moviesList.firstOrNull { it.title == movieName }
    Surface {
        Scaffold (
            topBar = {
                 TopNavBar(onBackClick = {
                     navController.popBackStack()
                 })
            },
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

@Preview (showBackground = true)
@Composable
fun PreviewMovieScreen() {
//    MovieScreen(navController = rememberNavController())
}