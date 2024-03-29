package com.example.movieapp.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailsRow(
    modifier: Modifier = Modifier,
    details: Map<String, String> = emptyMap()
) {
    Row (
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        LazyColumn {
            items(details.entries.toList()){
                detail ->
                    AnnotatedText(
                        heading = detail.key,
                        value = detail.value,
                        titleColor = Color.Black,
                        bodyColor = Color.DarkGray
                    )
            }
        }
    }
}