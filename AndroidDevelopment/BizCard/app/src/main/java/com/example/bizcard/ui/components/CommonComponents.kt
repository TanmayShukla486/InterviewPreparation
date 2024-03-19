package com.example.bizcard.ui.components

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizcard.data.dummyProject
import com.example.bizcard.ui.screens.ProjectItem

@Composable
fun PortfolioItem(
    modifier: Modifier = Modifier,
    item: ProjectItem,
    uriHandler: UriHandler
) {
    Surface (
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .height(100.dp)
    ) {
        Row (
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (
                modifier.fillMaxWidth(0.33f)
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    modifier = modifier
                        .padding(10.5.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .shadow(
                            elevation = 100.dp,
                            ambientColor = Color.DarkGray
                        )
                )
            }
            Column (
                modifier.fillMaxWidth(0.67f),
                verticalArrangement = Arrangement.Top
            ) {
                Row (
                    modifier = modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = item.name,
                        style = TextStyle(
                            fontFamily = FontFamily.Serif,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold,
                            shadow = Shadow(
                                color = Color.DarkGray,
                                offset = Offset(3f,4f),
                                blurRadius = 4f
                            )
                        )
                    )
                }
                Spacer(modifier = modifier.height(8.dp))
                Row {
                    Text(
                        text = item.desc,
                        style = TextStyle(
                            color = Color.Gray,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Light,
//                            shadow = Shadow(
//                                color = Color.DarkGray,
//                                offset = Offset(3f,4f),
//                                blurRadius = 4f
//                            )
                        )
                        )
                }
                Spacer(modifier = modifier.height(8.dp))
                Row {
                    ClickableText(
                        text = AnnotatedString("Project link"),
                        style = TextStyle(
                            color = Color(0xff008DDA),
                            fontFamily = FontFamily.Cursive,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
//                            shadow = Shadow(
//                                color = Color.DarkGray,
//                                offset = Offset(3f,4f),
//                                blurRadius = 4f,
//                            ),
                            textDecoration = TextDecoration.Underline)
                    ) {
                        uriHandler.openUri(item.link)
                    }
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewPortfolioItem() {
    PortfolioItem(item = dummyProject, uriHandler = LocalUriHandler.current)
}