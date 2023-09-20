package com.ephirium.roleparty.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ephirium.roleparty.presentation.viewmodel.ActiveUserViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RolePlaysScreen(navController: NavController) {

    val activeUserViewModel: ActiveUserViewModel = koinViewModel()



}
