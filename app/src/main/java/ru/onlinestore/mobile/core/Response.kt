package ru.onlinestore.mobile.core

sealed class Response<out SUCCESS, out INVALID> {

    fun <R> mapSuccess(mapper: ((SUCCESS) -> R)) =
        when(this) {
            is Error.ClientRequest -> Error.ClientRequest(status, message)
            is Error.Io -> Error.Io(message)
            is Error.Serialization -> Error.Serialization(message)
            is Error.ServerResponse -> Error.ServerResponse(status, message)
            is Invalid -> Invalid(data)
            is Loading -> Loading
            is Success -> Success(mapper(data))
            is Unknow -> Unknow
        }

    fun <R> mapInvalid(mapper: ((INVALID) -> R)) =
        when(this) {
            is Error.ClientRequest -> Error.ClientRequest(status, message)
            is Error.Io -> Error.Io(message)
            is Error.Serialization -> Error.Serialization(message)
            is Error.ServerResponse -> Error.ServerResponse(status, message)
            is Invalid -> Invalid(mapper(data))
            is Loading -> Loading
            is Success -> Success(data)
            is Unknow -> Unknow
        }

    abstract val state: ResponseEnum

    data class Success<T>(val data: T): Response<T, Nothing>() {
        override val state: ResponseEnum
            get() = ResponseEnum.SUCCESS
    }

    data object Loading: Response<Nothing, Nothing>() {
        override val state: ResponseEnum
            get() = ResponseEnum.LOADING
    }

    data class Invalid<I>(val data: I): Response<Nothing, I>() {
        override val state: ResponseEnum
            get() = ResponseEnum.INVALID
    }

    data object Unknow: Response<Nothing, Nothing>() {
        override val state: ResponseEnum
            get() = ResponseEnum.UNKNOW
    }

    sealed class Error: Response<Nothing, Nothing>() {

        data class ClientRequest(val status: Int, val message: String?): Error() {
            override val state: ResponseEnum
                get() = ResponseEnum.ERROR_CLIENT_REQUEST
        }

        data class ServerResponse(val status: Int, val message: String?): Error() {
            override val state: ResponseEnum
                get() = ResponseEnum.ERROR_SERVER_RESPONSE
        }

        data class Io(val message: String?): Error() {
            override val state: ResponseEnum
                get() = ResponseEnum.ERROR_IO
        }

        data class Serialization(val message: String?): Error() {
            override val state: ResponseEnum
                get() = ResponseEnum.ERROR_SERIALIZATION
        }
    }
}