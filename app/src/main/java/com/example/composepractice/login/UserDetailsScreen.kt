package com.example.composepractice.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun UserDetailsScreen(email: String?, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ,
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Welcome! $email")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .align(Alignment.CenterEnd)
            ,
            onClick = { navController.navigate(Screen.PickWeightScreen.route) }
        ) {
            Text(text = "Pick weight")
        }
    }
}