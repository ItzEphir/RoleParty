package com.ephirium.roleparty.presentation.mapper

import com.ephirium.roleparty.data.model.UserDto
import com.ephirium.roleparty.presentation.model.implementation.UserImpl

fun UserDto.convertForPresentation(): UserImpl = UserImpl(login, email)