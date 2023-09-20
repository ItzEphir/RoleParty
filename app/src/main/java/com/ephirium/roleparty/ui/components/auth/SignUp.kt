package com.ephirium.roleparty.ui.components.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ephirium.roleparty.presentation.model.implementation.UserImpl
import com.ephirium.roleparty.presentation.viewmodel.ActiveUserViewModel
import com.ephirium.roleparty.ui.navigation.Destinations
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUp(
    navController: NavController,
    activeUserViewModel: ActiveUserViewModel = koinViewModel(),
) {

    var emailField by remember {
        mutableStateOf(String())
    }

    var loginField by remember {
        mutableStateOf(String())
    }

    var passwordField by remember {
        mutableStateOf(String())
    }

    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {


        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = emailField,
            onValueChange = { emailField = it },
            label = {
                Text(text = "Enter your email")
            })

        SigningLayout(modifier = Modifier.fillMaxWidth(), onLoginChange = {
            loginField = it
        }, onPasswordChange = {
            passwordField = it
        })

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            activeUserViewModel.updateActiveUser(UserImpl(loginField, emailField))
        }) {
            Text(text = "Sign Up")
        }

        Button(modifier = Modifier.wrapContentWidth(), onClick = {
            navController.navigate(Destinations.Auth.Nested.SignIn.route)
        }) {
            Text(text = "Already has an account? Sign in!")
        }
    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignUp(rememberNavController())
}