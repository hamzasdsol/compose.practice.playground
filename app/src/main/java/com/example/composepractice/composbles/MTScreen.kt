package com.example.composepractice.composbles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MTScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF153B42), Color(0xFF222222)
                        ),
                    )
                )
        ) {
            MenuBackground(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(y = 32.dp)
            )
            ProfileImageBackground(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(y = 32.dp)
            )
            Text(
                text = "Some text to show",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        LoadDumpProgress(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp),
            onComplete = {
                //navController.navigate(MTScreens.MTScreen2.route)
            }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFF11B4D4))
        ) {
            Text(
                text = "Some text to show for bottom box",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}