package com.example.movieapp.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.movieapp.R
import com.example.movieapp.navigation.MovieScreens

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val scale = remember{
        Animatable(0f);
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(1f,
            animationSpec = tween(500,
                easing = EaseInBounce)
        )
        navController.popBackStack()
        navController.navigate(MovieScreens.HomeScreen.name)
    }

    Surface (
        modifier = modifier.fillMaxSize()
    ) {
        Column (
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.thumbnail),
                contentDescription = null,
                alpha = scale.value
            )
        }
    }
}