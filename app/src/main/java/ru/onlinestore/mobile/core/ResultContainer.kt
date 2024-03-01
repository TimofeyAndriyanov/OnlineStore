package ru.onlinestore.mobile.core


sealed class ResultContainer<T> {
    fun <R> map(mapper: ((T) -> R)? = null): ResultContainer<R> =
        when(this) {
            is LoadingResult -> LoadingResult()

            is SuccessResult -> {
                if (mapper == null) throw IllegalStateException("mapper не должен быть нулевым")
                SuccessResult(mapper(this.data))
            }

            is ErrorResult -> ErrorResult(this.exception)
        }
}

sealed class FinalResultContainer<T>: ResultContainer<T>()

class LoadingResult<T>: ResultContainer<T>()

data class ErrorResult<T>(val exception: Exception): FinalResultContainer<T>()

data class SuccessResult<T>(val data: T): FinalResultContainer<T>()