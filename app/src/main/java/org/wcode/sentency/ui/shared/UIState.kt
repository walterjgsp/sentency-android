package org.wcode.sentency.ui.shared


class UIState<out T> @PublishedApi internal constructor(
    @PublishedApi
    internal val data: Any?
) {

    val isSuccess: Boolean get() = data !is Error && data !is Loading

    val isError: Boolean get() = data is Error

    val isLoading: Boolean get() = data is Loading

    companion object {

        fun <T> success(value: T): UIState<T> = UIState(value)

        fun <T> error(exception: Throwable): UIState<T> = UIState(createError(exception))

        fun <T> loading(): UIState<T> = UIState(createLoading())
    }

    internal class Error(
        val exception: Throwable
    ) {
        override fun equals(other: Any?): Boolean = other is Error && exception == other.exception
        override fun hashCode(): Int = exception.hashCode()
        override fun toString(): String = "Error($exception)"
    }

    internal class Loading {
        override fun equals(other: Any?): Boolean = other is Loading
        override fun hashCode(): Int = this.hashCode()
    }

    @Suppress("UNCHECKED_CAST")
    fun getOrNull(): T? = when {
        isError -> null
        isLoading -> null
        else -> data as T
    }

    fun exceptionOrNull(): Throwable? = when (data) {
        is Error -> data.exception
        else -> null
    }

}

private fun createError(exception: Throwable): Any = UIState.Error(exception)

private fun createLoading(): Any = UIState.Loading()

inline fun <T> UIState<T>.onError(action: (exception: Throwable) -> Unit): UIState<T> {
    exceptionOrNull()?.let {
        action(it)
    }
    return this
}

inline fun <T> UIState<T>.onSuccess(action: (data: T) -> Unit): UIState<T> {
    getOrNull()?.let {
        action(it)
    }
    return this
}

inline fun <T> UIState<T>.onLoading(action: () -> Unit): UIState<T> {
    if (isLoading) {
        action()
    }
    return this
}