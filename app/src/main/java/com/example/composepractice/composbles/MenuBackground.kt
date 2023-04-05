package com.example.composepractice.composbles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composepractice.R

@Composable
fun MenuBackground(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .paint(
                painter = painterResource(id = R.drawable.menu_bg),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.Center)
                .size(24.dp),
            imageVector = Icons.Default.Menu,
            contentDescription = "menu icon",
            tint = MaterialTheme.colors.primary
        )
    }
}