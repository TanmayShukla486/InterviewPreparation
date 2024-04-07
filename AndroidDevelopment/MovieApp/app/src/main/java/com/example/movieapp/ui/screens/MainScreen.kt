package com.example.movieapp.ui.screens

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.data.Movie
import com.example.movieapp.ui.screens.components.MainScreenBody
import com.example.movieapp.ui.widgets.ScreenShotRow
import com.example.movieapp.ui.widgets.TopNavBar

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    data: List<Movie>
) {
    Surface() {
        Scaffold (
            topBar = {
                 TopNavBar(
                     modifier = modifier.height(50.dp),
                     onBackClick = { navController.popBackStack() }
                 )
            },
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

@Preview (showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController(), data = emptyList())
}