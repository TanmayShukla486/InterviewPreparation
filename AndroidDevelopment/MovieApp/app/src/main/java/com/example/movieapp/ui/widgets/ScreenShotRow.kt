package com.example.movieapp.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.R

@Composable
fun ScreenShotRow(
    list: List<String> = emptyList()
) {
    LazyRow {
        items(10) {
            ScreenShotImage()
        }
    }
}

@Composable
private fun ScreenShotImage(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier.padding(6.dp).clip(RoundedCornerShape(8.dp)),
        painter = painterResource(id = R.drawable.screenshot),
        contentDescription = null)
}

@Preview (showBackground = true)
@Composable
fun PreviewScreenShotRow() {
    ScreenShotRow()
}