package com.example.composepractice

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composepractice.login.Screen
import com.example.composepractice.login.MenuBackground


@Composable
fun LoginScreen(navController: NavController) {
    MenuBackground(
        modifier = Modifier
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var emailState by remember { mutableStateOf("") }
        var passwordState by remember { mutableStateOf("") }
        val context = LocalContext.current
        TextField(
            modifier = Modifier.background(Color.LightGray),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.LightGray,
                cursorColor = Color.Black,
                disabledLabelColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            value = emailState, onValueChange = {
                emailState = it
            }, label = { Text("Email") },
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier.background(Color.LightGray),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.LightGray,
                cursorColor = Color.Black,
                disabledLabelColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = PasswordVisualTransformation(),
            value = passwordState, onValueChange = {
                passwordState = it
            }, label = { Text("Password") },
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (emailState.isNotEmpty() && passwordState.isNotEmpty() && passwordState.length > 5) {
                navController.navigate(Screen.UserDetailsScreen.withArgs(emailState))
                emailState = ""
                passwordState = ""
                Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
            }
        }, modifier = Modifier.align(Alignment.End)) {
            Text("Login")
        }
    }
}