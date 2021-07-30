package org.wcode.sentency.domain.network.responses

data class QuoteResponse(
    val id: String,
    val authorId: String,
    val timestamp: Long,
    val author: AuthorResponse,
    val type: String? = null,
    val messages: List<MessageResponse>
)