package com.ephirium.roleparty.presentation.model.screenstates

data class AuthScreenState(
    val loginFieldState: String = String(),
    val passwordFieldState: String = String(),
    val emailFieldState: String = String(),
)
