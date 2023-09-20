package com.ephirium.roleparty.ui.components.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.ephirium.roleparty.ui.navigation.Destinations

@Composable
fun SignIn(navController: NavController) {
    var loginField by remember {
        mutableStateOf(String())
    }

    var passwordField by remember {
        mutableStateOf(String())
    }

    Column {
        SigningLayout(
            onLoginChange = {
                loginField = it
            },
            onPasswordChange = {
                passwordField = it
            }
        )

        Button(
            onClick = {
                navController.navigate(Destinations.Chats.route)
            }
        ) {
            Text(text = "Sign in")
        }
    }
}