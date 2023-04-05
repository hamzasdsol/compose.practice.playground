package com.example.composepractice.weightpicker

import androidx.compose.runtime.Composable

@Composable
fun WheelTextPickerCustom() {
    val values = listOf("00", "01", "02", "03", "04", "05", "06", "07", "08")
    WheelTextPicker(
        texts = values,
        rowCount = 3,
        onScrollFinished = {snappedIndex ->
            if (snappedIndex < values.size) {
                println("wheelpicker snappedIndex = $snappedIndex")
                println("wheelpicker value = ${values[snappedIndex]}")
            }
            snappedIndex
        }
    )
}