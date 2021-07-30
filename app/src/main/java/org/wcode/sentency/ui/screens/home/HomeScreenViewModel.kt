package org.wcode.sentency.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.wcode.sentency.domain.network.responses.QuoteResponse
import org.wcode.sentency.domain.repository.QuoteRepository
import org.wcode.sentency.ui.shared.UIState

class HomeScreenViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    private val _state = MutableStateFlow<UIState<QuoteResponse>>(UIState.loading())
    val state = _state.asStateFlow()

    init {
        nextQuote()
    }

    fun nextQuote() {
        viewModelScope.launch {
            _state.emit(UIState.loading())
            quoteRepository.getRandomQuote().catch { e ->
                _state.emit(UIState.error(e))
            }.collect {
                _state.emit(UIState.success(it))
            }
        }
    }
}