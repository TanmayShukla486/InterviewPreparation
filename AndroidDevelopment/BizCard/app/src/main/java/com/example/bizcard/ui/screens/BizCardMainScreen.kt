package com.example.bizcard.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizcard.R
import com.example.bizcard.data.dummyProject
import com.example.bizcard.ui.components.PortfolioItem


val ids = listOf(0,1,2,3,4,5,6,7,8,9)
@Composable
fun BizCardMainScreen(
    modifier: Modifier = Modifier,
    listOfProjects: List<ProjectItem> = emptyList(),
    localUriHandler: UriHandler = LocalUriHandler.current
//    onClickButton: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xffACE2E1)
    ){
        var displayProject by remember {
            mutableStateOf(true)
        }
        val hiddenPortfolioButtonText = "Show Projects"
        val visiblePortfolioButtonText = "Hide Projects"
        val username = "Tanmay Shukla"
        Card (
            modifier = modifier
                .fillMaxSize()
                .padding(15.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xffF7EEDD)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 35.dp
            )
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row (
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = null,
                        modifier = modifier
                            .clip(CircleShape)
                            .shadow(
                                elevation = 50.dp,
                                spotColor = Color.DarkGray
                            )
                    )
                }
                Spacer(modifier = modifier.height(25.dp))
                Row (
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = username,
                        style = TextStyle(
                            fontFamily = FontFamily.Cursive,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold,
                            shadow = Shadow(
                                color = Color.DarkGray,
                                offset = Offset(3f,4f),
                                blurRadius = 8f
                            )
                        )
                    )
                }
                Spacer(modifier = modifier.height(25.dp))
                Row (
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { displayProject = !displayProject},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff008DDA)
                        )
                    ) {
                        Text(
                            text = if (displayProject) hiddenPortfolioButtonText else visiblePortfolioButtonText,
                            style = TextStyle(
                                fontFamily = FontFamily.Cursive,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.ExtraBold,
                                shadow = Shadow(
                                    color = Color.DarkGray,
                                    offset = Offset(3f,4f),
                                    blurRadius = 8f
                                )
                            ))
                    }
                }
                Spacer(modifier = modifier.height(10.dp))
                Row (
                    modifier = modifier
                        .padding(bottom = 15.dp),

                ) {
                if (!displayProject) {
                    LazyColumn(
                        modifier = modifier,
                    ) {
                        items(
                            count = 10,
                            key = {
                                ids[it]
                            }) {
                            PortfolioItem(item = dummyProject, uriHandler = localUriHandler)
                            Spacer(modifier = modifier.height(5.dp))
                        }
                    }
                }
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewBizCardMainScreen() {
    BizCardMainScreen()
}