package com.ephirium.roleparty.ui.components.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.ephirium.roleparty.common.Empties
import com.ephirium.roleparty.common.OnReceiveListener

@Composable
fun SigningLayout(
    modifier: Modifier = Modifier,
    onLoginChange: OnReceiveListener<String>,
    onPasswordChange: OnReceiveListener<String>,
) {
    var loginField by remember {
        mutableStateOf(String())
    }

    var passwordField by remember {
        mutableStateOf(String())
    }

    Box(modifier = modifier) {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = loginField,
                onValueChange = {
                    loginField = it
                    onLoginChange(it)
                },
                label = {
                    Text(text = "Enter your login")
                },
                singleLine = true
            )

            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = passwordField,
                onValueChange = {
                    passwordField = it
                    onPasswordChange(it)
                },
                label = {
                    Text(text = "Enter your password")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SigningLayoutPreview() {
    SigningLayout(
        onLoginChange = Empties.receiveListener,
        onPasswordChange = Empties.receiveListener
    )
}

