package com.example.movieapp.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.data.Movie
import com.example.movieapp.data.dummyMovie
import com.example.movieapp.ui.widgets.DetailsRow
import com.example.movieapp.ui.widgets.ScreenShotRow
import com.example.movieapp.ui.widgets.TitleRow

@Composable
fun MovieScreenBody(
    modifier: Modifier = Modifier,
    movie: Movie = dummyMovie
) {
    Column {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = "ScreenShots",
            style = MaterialTheme.typography.titleLarge
        )
        ScreenShotRow()
        Card (
            modifier = modifier.padding(12.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xffFFFFA1)
            )
        ) {
            TitleRow(
                title = movie.name
            )
            // Includes all the details such as year of release, rating, director
            DetailsRow(
                details = mapOf(
                    "Director" to movie.director,
                    "Writer" to movie.writer,
                    "Rating" to movie.rating.toString(),
                    "Year of Release" to movie.release,
                    "Cast" to movie.cast,
                    "Plot" to movie.plot,
                    "Production" to movie.production,
                )
            )
        }

    }
}

@Preview (showBackground = true)
@Composable
fun PreviewMovieScreenBody() {
    MovieScreenBody()
}