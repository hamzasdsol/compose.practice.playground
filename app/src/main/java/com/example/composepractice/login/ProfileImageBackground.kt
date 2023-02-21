package com.example.composepractice.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ProfileImageBackground(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(size = 100.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 50.dp,
                    topEnd = 0.dp,
                    bottomStart = 50.dp,
                    bottomEnd = 0.dp
                )
            )
            .background(color = MaterialTheme.colors.secondary)
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(
                    topStart = 50.dp,
                    topEnd = 0.dp,
                    bottomStart = 50.dp,
                    bottomEnd = 0.dp
                )
            )
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.Center)
                .size(50.dp),
            imageVector = Icons.Default.Menu,
            contentDescription = "menu icon",
            tint = MaterialTheme.colors.primary
        )
    }
}