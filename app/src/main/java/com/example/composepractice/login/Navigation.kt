package com.example.composepractice.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composepractice.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.UserDetailsScreen.route + "/{email}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            UserDetailsScreen(email = entry.arguments?.getString("email"), navController)
        }

        composable(route = Screen.PickWeightScreen.route) {
            PickWeightScreen()
        }

        composable(route = Screen.MTScreen2.route) {
            MTScreen2()
        }
    }
}