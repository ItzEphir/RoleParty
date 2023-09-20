package com.ephirium.roleparty.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ephirium.roleparty.ui.navigation.Destinations
import com.ephirium.roleparty.ui.navigation.authGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.Auth.route) {
        authGraph(navController)

        composable(route = Destinations.Chats.route) {
            RolePlaysScreen(navController)
        }
    }
}
