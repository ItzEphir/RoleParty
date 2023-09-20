package com.ephirium.roleparty.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ephirium.roleparty.presentation.viewmodel.ActiveUserViewModel
import com.ephirium.roleparty.presentation.viewmodel.AuthScreenViewModel
import com.ephirium.roleparty.ui.navigation.Destinations
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthScreen(navController: NavController) {
    val activeUserViewModel: ActiveUserViewModel = koinViewModel()
    val authScreenViewModel: AuthScreenViewModel = koinViewModel()
    val activeUser = activeUserViewModel.activeUser.collectAsStateWithLifecycle()

    navController.navigate(
        when (activeUser.value) {
            null -> Destinations.Auth.Nested.SignUp.route
            else -> Destinations.Chats.route
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen(rememberNavController())
}