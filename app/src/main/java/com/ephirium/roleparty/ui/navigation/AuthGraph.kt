package com.ephirium.roleparty.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ephirium.roleparty.ui.components.AuthScreen
import com.ephirium.roleparty.ui.components.auth.SignIn
import com.ephirium.roleparty.ui.components.auth.SignUp

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(
        route = Destinations.Auth.route,
        startDestination = Destinations.Auth.Nested.Main.route
    ) {
        composable(route = Destinations.Auth.Nested.Main.route){
            AuthScreen(navController)
        }
        composable(route = Destinations.Auth.Nested.SignUp.route){
            SignUp(navController)
        }
        composable(route = Destinations.Auth.Nested.SignIn.route){
            SignIn(navController)
        }
    }
}