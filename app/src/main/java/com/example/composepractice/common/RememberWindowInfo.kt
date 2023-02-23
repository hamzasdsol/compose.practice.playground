package com.example.composepractice.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composepractice.common.WindowInfo.Companion.MINI_TAB_MAX_WIDTH
import com.example.composepractice.common.WindowInfo.Companion.PHONE_MAX_WIDTH
import com.example.composepractice.common.WindowInfo.Companion.PHONE_MAX_HEIGHT
import com.example.composepractice.common.WindowInfo.Companion.MINI_TAB_MAX_HEIGHT

@Composable
fun RememberWindowInfo(): WindowInfo {
    val configuration = LocalConfiguration.current
    return WindowInfo(
        screenWidthInfo = when {
            configuration.screenWidthDp < PHONE_MAX_WIDTH -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < MINI_TAB_MAX_WIDTH -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenHeightInfo = when {
            configuration.screenHeightDp < PHONE_MAX_HEIGHT -> WindowInfo.WindowType.Compact
            configuration.screenHeightDp < MINI_TAB_MAX_HEIGHT -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenWidth = configuration.screenWidthDp.dp,
        screenHeight = configuration.screenHeightDp.dp
    )
}

data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeight: Dp,

    ) {
    sealed class WindowType {
        object Compact : WindowType()
        object Medium : WindowType()
        object Expanded : WindowType()
    }

    /**
    below 600 = phone
    between 600 and 840 = mini tab
    above 840 = tablet
     */
    companion object {
        const val PHONE_MAX_WIDTH = 600
        const val PHONE_MAX_HEIGHT = 480
        const val MINI_TAB_MAX_WIDTH = 840
        const val MINI_TAB_MAX_HEIGHT = 900
    }
}