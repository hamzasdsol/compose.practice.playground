package com.example.composepractice.login

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun MyIndicator() {
//    var indicatorProgress by remember {
//        mutableStateOf(0f)
//    }
//    val countDownTimer =
//        object : CountDownTimer(10000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                Log.d("TAG", "onTick: $millisUntilFinished")
//                indicatorProgress = millisUntilFinished / 1000f
//            }
//
//            override fun onFinish() {
//                Log.d("TAG", "onFinish")
//            }
//        }
//    DisposableEffect(Unit) {
//        countDownTimer.start()
//        onDispose {
//            countDownTimer.cancel()
//        }
//    }
//    var progress by remember { mutableStateOf(0f) }
//    val progressAnimDuration = 1000
//    val progressAnimation by animateFloatAsState(
//        targetValue = indicatorProgress,
//        animationSpec = tween(durationMillis = progressAnimDuration, easing = FastOutSlowInEasing)
//    )
//    LinearProgressIndicator(
//        modifier = Modifier
//            .fillMaxWidth(),
//        progress = progressAnimation,
//        color = Color.Black
//    )
//    LaunchedEffect(indicatorProgress) {
//        progress = indicatorProgress
//    }

    var bikeState by remember { mutableStateOf(BikePosition.Start) }

    val offsetAnimation: Dp by animateDpAsState(
        if (bikeState == BikePosition.Start) 5.dp else 300.dp,
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .absoluteOffset(x = offsetAnimation),
            color = Color.Black
        )

        Button(
            onClick = {
                bikeState = when (bikeState) {
                    BikePosition.Start -> BikePosition.Finish
                    BikePosition.Finish -> BikePosition.Start
                }
            }, modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        ) {
            Text(text = "Start animation")
        }
    }
}

enum class BikePosition {
    Start, Finish
}