package com.example.movieapp.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.R

@Composable
fun ScreenShotRow(
    list: List<String> = emptyList()
) {
    val focusedIndex = remember {
        mutableIntStateOf(0)
    }
    LazyRow {
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
            .padding(6.dp)
            .clip(RoundedCornerShape(8.dp))
            .onFocusEvent {
                event ->
                          if (event.isFocused) focusedIndex.value = index
            },
        painter = painterResource(id = R.drawable.screenshot),
        contentDescription = null)
}

@Preview (showBackground = true)
@Composable
fun PreviewScreenShotRow() {
    ScreenShotRow()
}