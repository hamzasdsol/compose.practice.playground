package com.example.composepractice.composbles

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun LoadDumpProgress(
    modifier: Modifier = Modifier,
    duration: Int = 5000,
    onComplete: () -> Unit
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val percentage = animateFloatAsState(
        targetValue = if (animationPlayed) 1f else 0f,
        animationSpec = tween(
            durationMillis = duration,
            easing = LinearEasing,
        ),
        finishedListener = {
            onComplete.invoke()
        }
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    LinearProgressIndicator(
        modifier = modifier,
        progress = percentage.value
    )
}