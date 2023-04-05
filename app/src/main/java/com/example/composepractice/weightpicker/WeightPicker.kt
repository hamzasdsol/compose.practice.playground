package com.example.composepractice.weightpicker

import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WeightPicker() {
    val possibleValues = listOf(1, 2, 3, 4, 5, 6, 7)
    var state by remember { mutableStateOf(possibleValues[0]) }
    ListItemPickerCustom(
        textStyle = MaterialTheme.typography.h2,
        dividersColor = Color.Transparent,
        label = { it.toString() },
        value = state,
        onValueChange = { state = it },
        list = possibleValues
    )


}