package com.example.composepractice.login

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun MTScreen2() {
    val context = LocalContext.current
    LoadDumpProgress(
        modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
        ,
        onComplete = {
            Toast.makeText(
                context,
                "Completed",
                Toast.LENGTH_LONG
            ).show()
        }
    )
}