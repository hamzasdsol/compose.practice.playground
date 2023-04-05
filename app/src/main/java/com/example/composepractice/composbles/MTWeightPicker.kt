package com.example.composepractice.composbles

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composepractice.ui.theme.Bottom
import com.example.composepractice.weightpicker.WheelTextPicker

@Composable
fun MTWeightPicker() {
    val integerList = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    val decimalList = listOf("00", "01", "02", "03", "04", "05", "06", "07", "08", "09")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0F525F),
                        Color.Black
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Canvas(modifier = Modifier.matchParentSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawLine(
                start = Offset(x = 0f, y = canvasHeight / 1.75f),
                end = Offset(x = canvasWidth, y = canvasHeight / 1.75f),
                color = Color(0xFF99f5ff).copy(alpha = 0.2f),
                strokeWidth = 2F
            )

            drawLine(
                start = Offset(x = 0f, y = canvasHeight / 2.25f),
                end = Offset(x = canvasWidth, y = canvasHeight / 2.25f),
                color = Color(0xFF99f5ff).copy(alpha = 0.2f),
                strokeWidth = 2F
            )
        }
        Row(
            modifier = Modifier.matchParentSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            WheelTextPicker(
                texts = integerList,
                onScrollFinished = { snappedIndex ->
                    if (snappedIndex < integerList.size) {
                        println("wheelpicker snappedIndex = $snappedIndex")
                        println("wheelpicker value = ${integerList[snappedIndex]}")
                    }
                    snappedIndex
                }
            )
            Text(text = ",", style = MaterialTheme.typography.h1, color = Color(0xFFFFC107))
            WheelTextPicker(
                texts = decimalList,
                onScrollFinished = { snappedIndex ->
                    if (snappedIndex < decimalList.size) {
                        println("wheelpicker snappedIndex = $snappedIndex")
                        println("wheelpicker value = ${decimalList[snappedIndex]}")
                    }
                    snappedIndex
                }
            )
            Spacer(modifier = Modifier.width(32.dp))
            Text(text = "Tonn", style = MaterialTheme.typography.h1, color = Color(0xFF06EBFF))
        }
    }
}