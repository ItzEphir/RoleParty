package com.ephirium.roleparty.di

import com.ephirium.roleparty.presentation.viewmodel.ActiveUserViewModel
import com.ephirium.roleparty.presentation.viewmodel.AuthScreenViewModel
import com.ephirium.roleparty.presentation.viewmodel.AuthScreenViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<ActiveUserViewModel> {
        ActiveUserViewModel(
            loadActiveUserUseCase = get(), saveActiveUserUseCase = get()
        )
    }

    viewModel<AuthScreenViewModel> {
        AuthScreenViewModelImpl()
    }
}