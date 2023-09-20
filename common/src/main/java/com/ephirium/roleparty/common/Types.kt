package com.ephirium.roleparty.common

typealias OnReceiveListener<T> = (value: T) -> Unit

typealias OnExceptionListener = (exception: Exception) -> Unit

typealias OnSuccessListener = () -> Unit
