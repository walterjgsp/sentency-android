package org.wcode.sentency.domain.network.responses

data class MessageResponse(
    val id: String,
    val message: String,
    val code: String,
    val quoteId: String
)
