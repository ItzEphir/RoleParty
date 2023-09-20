package com.ephirium.roleparty.di

import com.ephirium.roleparty.domain.usecase.LoadActiveUserUseCase
import com.ephirium.roleparty.domain.usecase.SaveActiveUserUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        SaveActiveUserUseCase(repository = get())
    }

    factory {
        LoadActiveUserUseCase(activeUserIdRepositoryBase = get(), userRepository = get())
    }

}