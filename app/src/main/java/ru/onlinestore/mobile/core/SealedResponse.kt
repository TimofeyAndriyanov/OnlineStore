package ru.onlinestore.mobile.core

sealed class SealedResponse<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T): SealedResponse<T>(data)

    class Loading<T>(data: T? = null): SealedResponse<T>(data)

    class Error<T>(message: String, data: T? = null): SealedResponse<T>(data, message)
}