package ru.onlinestore.mobile.core

sealed class Response<out T, out I> {

    fun<R> mapT(mapper: ((T) -> R)): Response<R, I> =
        when(this) {
            is Success -> Success(mapper(data))

            is Invalid -> Invalid(data = data)

            is Error -> Error(exception = exception)

            is Loading -> Loading

            is Empty -> Empty
        }

    fun<R> mapI(mapper: ((I) -> R)): Response<T, R> =
        when(this) {
            is Success -> Success(data = data)

            is Invalid -> Invalid(data = mapper(data))

            is Error -> Error(exception = exception)

            is Loading -> Loading

            is Empty -> Empty
        }

    class Success<T>(val data: T): Response<T, Nothing>()

    class Invalid<I>(val data: I): Response<Nothing, I>()

    class Error(val exception: Exception): Response<Nothing, Nothing>()

    data object Loading: Response<Nothing, Nothing>()

    data object Empty: Response<Nothing, Nothing>()
}
