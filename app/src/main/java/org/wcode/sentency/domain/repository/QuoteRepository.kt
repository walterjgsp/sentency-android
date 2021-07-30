package org.wcode.sentency.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.wcode.sentency.domain.network.responses.QuoteResponse
import org.wcode.sentency.domain.network.services.QuoteService

class QuoteRepository(private val quoteService: QuoteService) {

    suspend fun getRandomQuote(): Flow<QuoteResponse> = flow {
        try {
            emit(quoteService.getRandomQuote())
        } catch (e: Exception) {
            throw e
        }
    }
}