package com.example.composepractice.login

import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.loader.content.Loader
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun MTScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White)
        ) {
            Text(text = "Some text to show", modifier = Modifier.align(Alignment.Center))
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
                .background(Color.White)
        ) {
            Text(
                text = "Some text to show for bottom box",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}