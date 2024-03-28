package com.example.movieapp.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Surface (
        modifier = modifier.fillMaxSize()
    ) {
        val scale = remember{
            Animatable(0f);
        }
    }
}