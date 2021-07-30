package org.wcode.sentency.domain.network.services

import org.wcode.sentency.domain.network.responses.QuoteResponse
import retrofit2.Response
import retrofit2.http.GET

interface QuoteService {

    @GET("quote/random")
    suspend fun getRandomQuote(): QuoteResponse

}