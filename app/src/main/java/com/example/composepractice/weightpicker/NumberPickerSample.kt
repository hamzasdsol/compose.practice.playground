package com.example.composepractice.weightpicker

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NumberPickerSample() {
    Box(modifier = Modifier.fillMaxSize()) {
        NumberPicker(
            state = remember { mutableStateOf(9) },
            range = 0..10,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}