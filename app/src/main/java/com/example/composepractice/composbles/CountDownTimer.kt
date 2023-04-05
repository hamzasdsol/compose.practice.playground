package com.example.composepractice.composbles

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Timer() {
    val millisInFuture: Long = 10 * 1000 // 10 seconds timer

    val timeData = remember {
        mutableStateOf(millisInFuture)
    }

    val countDownTimer =
        object : CountDownTimer(millisInFuture, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("TAG", "onTick: $millisUntilFinished")
                timeData.value = millisUntilFinished / 1000 // convert to seconds
            }

            override fun onFinish() {
                Log.d("TAG", "onFinish")
            }
        }

    DisposableEffect(key1 = "key") {
        countDownTimer.start()
        onDispose {
            countDownTimer.cancel()
        }
    }

    Text(
        modifier = Modifier.size(24.dp).fillMaxWidth(),
        text = timeData.value.toString()
    )
}