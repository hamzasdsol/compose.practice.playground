package com.example.composepractice.composbles

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MainScreenContainer() {
    var toggle = remember {
        mutableStateOf(false)
    }
    val navController = rememberNavController()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MenuBackground()
            Text(
                modifier = Modifier.clickable {
                    toggle.value = !toggle.value
                },
                text = "Toggle Button here"
            )
            ProfileImageBackground()
        }

        if (toggle.value)
            MTScreen2()
        else UserDetailsScreen(email = "Hamza Abid", navController = navController)
    }
}