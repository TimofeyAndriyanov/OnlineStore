package ru.onlinestore.mobile.core

sealed class Response<out T> {

    fun<R> map(mapper: ((T) -> R)): Response<R> =
        when(this) {
            is Success -> Success(mapper(data))

            is Error -> Error(exception = exception)

            is Loading -> Loading

            is Empty -> Empty
        }

    class Success<T>(val data: T): Response<T>()

    class Error(val exception: Exception): Response<Nothing>()

    data object Loading: Response<Nothing>()

    data object Empty: Response<Nothing>()
}
