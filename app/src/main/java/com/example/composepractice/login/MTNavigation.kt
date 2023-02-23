package com.example.composepractice.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MTNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MTScreens.MTScreen2.route
    ) {
        composable(
            MTScreens.MTScreen.route
        ) {
            MTScreen(navController = navController)
        }

        composable(
            MTScreens.MTScreen2.route
        ) {
            MTScreen2()
        }
    }
}