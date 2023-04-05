package com.example.composepractice.weightpicker

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun WheelTextPicker(
    modifier: Modifier = Modifier,
    startIndex: Int = 0,
    size: DpSize = DpSize(150.dp, 350.dp),
    texts: List<String>,
    rowCount: Int = 3,
    style: TextStyle = MaterialTheme.typography.h1,
    onScrollFinished: (snappedIndex: Int) -> Int? = { null },
) {
    WheelPicker(
        modifier = modifier,
        startIndex = startIndex,
        size = size,
        count = texts.size,
        rowCount = rowCount,
        onScrollFinished = onScrollFinished
    ) { index, selected ->
        Text(
            text = texts[index],
            style = style,
            color = if (selected) Color(0xFFFFC107) else Color(0xFF06EBFF),
            maxLines = 1
        )
    }
}