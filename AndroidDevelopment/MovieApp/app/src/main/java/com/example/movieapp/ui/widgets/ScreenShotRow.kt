package com.example.movieapp.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.R

@Composable
fun ScreenShotRow(
    modifier: Modifier = Modifier,
    list: List<String> = emptyList()
) {
    val focusedIndex = remember {
        mutableIntStateOf(0)
    }
    LazyRow (
            modifier = modifier
                .height(250.dp)
                .padding(16.dp)
    ) {
        items(10) {
            ScreenShotImage(
                index = it,
                focusedIndex = focusedIndex
            )
        }
    }
}

@Composable
private fun ScreenShotImage(
    modifier: Modifier = Modifier,
    index: Int,
    focusedIndex: MutableState<Int>
) {
    Image(
        modifier = modifier
            .fillMaxHeight()
            .width(375.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(8.dp))
            .shadow(
                elevation = 25.dp,
                ambientColor = Color.DarkGray,
                spotColor = Color.LightGray
            )
            .onFocusEvent { event ->
                if (event.isFocused) focusedIndex.value = index
            },
        painter = painterResource(id = R.drawable.screenshot),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
        )
}

@Preview (showBackground = true)
@Composable
fun PreviewScreenShotRow() {
    ScreenShotRow()
}