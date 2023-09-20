package com.ephirium.roleparty.presentation.model.implementation

import com.ephirium.roleparty.presentation.model.base.UserBase

data class UserImpl(
    override val login: String,
    override val email: String
) : UserBase