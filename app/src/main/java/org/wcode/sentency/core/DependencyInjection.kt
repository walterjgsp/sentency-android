package org.wcode.sentency.ui.shared

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.wcode.sentency.ui.screens.splash.SplashScreenViewModel

val viewModelModule = module {
    viewModel { SplashScreenViewModel() }
}