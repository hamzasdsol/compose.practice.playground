package com.example.composepractice.composbles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                .width(300.dp)
                .background(Color.Cyan.copy(alpha = 0.3f)),
            textStyle = MaterialTheme.typography.h2,
            dividersColor = Color.Transparent,
            value = decimalValue,
            range = 0..99,
            onValueChange = {
                decimalValue = it
            }
        )

        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = ",",
            fontStyle = FontStyle.Normal,
            fontSize = 60.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(16.dp))

        NumberPicker(
            modifier = Modifier
                .fillMaxHeight()
                .width(300.dp)
                .background(Color.Cyan.copy(alpha = 0.3f)),
            textStyle = MaterialTheme.typography.h2,
            value = integerValue,
            dividersColor = Color.Transparent,
            range = 0..9,
            onValueChange = {
                integerValue = it
            }
        )

        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Tonn",
            fontStyle = FontStyle.Normal,
            fontSize = 60.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}