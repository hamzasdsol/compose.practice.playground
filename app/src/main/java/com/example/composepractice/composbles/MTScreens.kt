package com.example.composepractice.composbles

sealed class MTScreens(val route: String) {
    object MTScreen: MTScreens("mt_screen_1")
    object MTScreen2: MTScreens("mt_screen_2")
}
