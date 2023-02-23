package com.example.composepractice.login

import android.os.Build
import android.widget.LinearLayout.SHOW_DIVIDER_NONE
import android.widget.NumberPicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MTScreen2() {
    var pickerValue by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        val textColor = MaterialTheme.colors.primary.toArgb()
        AndroidView(
            modifier = Modifier.wrapContentSize(),
            factory = { context ->
                NumberPicker(context).apply {
                    textSize = 60f
                    this.textColor = textColor
                    showDividers = SHOW_DIVIDER_NONE
                    setOnValueChangedListener { numberPicker, i, i2 ->
                        pickerValue = numberPicker.value
                    }
                    minValue = 0
                    maxValue = 50
                    value = 48
                }
            }
        )
        Text(
            text = ",",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primary
        )
        AndroidView(
            modifier = Modifier.wrapContentSize(),
            factory = { context ->
                NumberPicker(context).apply {
                    textSize = 60f
                    this.textColor = textColor
                    showDividers = SHOW_DIVIDER_NONE
                    setOnValueChangedListener { numberPicker, i, i2 ->
                        //pickerValue = numberPicker.value
                    }
                    minValue = 0
                    maxValue = 50
                    value = 25
                }
            }
        )
    }
}