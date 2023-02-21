package com.example.composepractice.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chargemap.compose.numberpicker.NumberPicker

@Composable
fun PickWeightScreen() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var integerValue by remember { mutableStateOf(0) }
        var decimalValue by remember { mutableStateOf(40) }

        NumberPicker(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp),
            value = decimalValue,
            range = 0..99,
            onValueChange = {
                decimalValue = it
            }
        )

        Spacer(modifier = Modifier.width(16.dp))
        Text(text = ",")
        Spacer(modifier = Modifier.width(16.dp))

        NumberPicker(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp),
            value = integerValue,
            range = 0..9,
            onValueChange = {
                integerValue = it
            }
        )

        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "Tonn")
    }
}