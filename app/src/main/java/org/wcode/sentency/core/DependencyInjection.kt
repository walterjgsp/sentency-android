package org.wcode.sentency.ui.shared

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.wcode.sentency.domain.network.services.QuoteService
import org.wcode.sentency.domain.network.createRetrofit
import org.wcode.sentency.domain.network.provideApi
import org.wcode.sentency.domain.network.responses.QuoteResponse
import org.wcode.sentency.domain.repository.QuoteRepository
import org.wcode.sentency.ui.screens.home.HomeScreenViewModel
import org.wcode.sentency.ui.screens.splash.SplashScreenViewModel

val viewModelModule = module {
    viewModel { SplashScreenViewModel() }
    viewModel { HomeScreenViewModel(get()) }
}

val networkModule = module {
    single { createRetrofit() }
    single { provideApi<QuoteService>(get()) }
}

val repositoryModule = module {
    single { QuoteRepository(get()) }
}