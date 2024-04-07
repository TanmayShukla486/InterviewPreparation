package com.example.movieapp.ui.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.Movie
import kotlin.math.ceil

@Composable
fun MovieRow(
    modifier: Modifier = Modifier,
    onClickButton: (Movie) -> Unit = {},
    movie: Movie,
) {
    val isExpanded = rememberSaveable {
        mutableStateOf(false)
    }
    val expandedHeight: Dp = if (movie.plot.length <= 200) 425.dp else 525.dp
    Surface (
        modifier = modifier
            .fillMaxWidth()
            .height(if (isExpanded.value) expandedHeight else 175.dp)
            .padding(16.dp)
            .clickable { isExpanded.value = !isExpanded.value },
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 4.dp
    ) {
        Row (
            modifier = modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            // Column composable for the image
            Column (
                modifier
                    .fillMaxWidth(0.33f)
                    .fillMaxHeight()
                    .padding(6.dp),
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    modifier = modifier.clip(RoundedCornerShape(8.dp)),
                    model = movie.poster,
                    contentDescription = null
                )
            }
            // Column composable for the text data
            Column {
                // Adding a row for the title
                Row (
                    modifier = modifier.fillMaxWidth()
                ) {
                    Text(
                        text = movie.title,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp
                    )
                }
                // Row composable for the minor details
                Row (
                    modifier.fillMaxWidth()
                ) {
                    Column {
                        AnnotatedText(heading = "Director", value = movie.director)
                        AnnotatedText(heading = "Rating", value = movie.rating)
                        AnnotatedText(heading = "Cast", value = movie.actors)
                        AnimatedVisibility(visible = isExpanded.value) {
                            Column {
                                AnnotatedText(heading = "Description", value = movie.plot)
                                Spacer(modifier = modifier.height(24.dp))
                                Button(
                                    modifier = modifier.size(width = 200.dp, height = 50.dp),
                                    onClick = {
                                        isExpanded.value = !isExpanded.value
                                        onClickButton.invoke(movie)
                                    }) {
                                    Text("Show More")
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}


@Composable
fun AnnotatedText(
    heading: String,
    value: String,
    titleFontWeight: FontWeight = FontWeight.Bold,
    titleColor: Color = Color.DarkGray,
    bodyFontWeight: FontWeight = FontWeight.Normal,
    bodyColor: Color = Color.Gray
) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(
                color = titleColor,
                fontSize = 14.sp,
                fontWeight = titleFontWeight
            )) {
                append(text = "${heading}:\t")
            }
            withStyle(style = SpanStyle(
                color = bodyColor,
                fontSize = 14.sp,
                fontWeight = bodyFontWeight
            )) {
                append(text = value)
            }
        }

    )
}


@Preview (showBackground = true)
@Composable
fun PreviewMovieRow() {
//    MovieRow()
}