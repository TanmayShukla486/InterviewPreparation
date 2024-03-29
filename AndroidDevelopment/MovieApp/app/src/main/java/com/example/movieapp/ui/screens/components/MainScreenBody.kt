package com.example.movieapp.ui.screens.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.data.Movie
import com.example.movieapp.ui.widgets.MovieRow

@Composable
fun MainScreenBody (
    modifier: Modifier = Modifier,
    navController: NavController,
    movies: List<Movie> = emptyList()
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(10) {
                MovieRow()
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewMainScreenBody() {
    MainScreenBody(navController = rememberNavController())
}