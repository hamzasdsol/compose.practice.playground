package com.example.composepractice.composbles

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object UserDetailsScreen : Screen("user_details_screen")
    object PickWeightScreen : Screen("pick_weight_screen")
    object MTScreen2 : Screen("mt_screen_2")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
