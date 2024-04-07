package com.example.movieapp.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.movieapp.data.Movie
import com.example.movieapp.ui.widgets.DetailsRow
import com.example.movieapp.ui.widgets.ScreenShotRow
import com.example.movieapp.ui.widgets.TitleRow

@Composable
fun MovieScreenBody(
    modifier: Modifier = Modifier,
    movie: Movie?
) {
    if (movie != null) {
    Column (
        modifier.padding(horizontal = 8.dp)
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = "ScreenShots",
            style = MaterialTheme.typography.titleLarge
        )
        ScreenShotRow(
            list = movie.images
        )
        Card(
            modifier = modifier
                .padding(12.dp)
                .fillMaxHeight(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            )
        ) {
            TitleRow(
                title = movie.title
            )
            Spacer(modifier = modifier.height(24.dp))
            // Includes all the details such as year of release, rating, director
            DetailsRow(
                details = mapOf(
                    "Director" to movie.director,
                    "Genre" to movie.genre,
                    "Rating" to movie.rating,
                    "Plot" to movie.plot,
                    "Actors" to movie.actors,
                    "Year of Release" to movie.year
                    )
                )
             }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewMovieScreenBody() {
//    MovieScreenBody()
}