package ru.onlinestore.mobile.core

data class Response<T>(
    val status: Status,
    val data: T?,
    val message: String?
) {

    enum class Status {
        SUCCESS,
        LOADING,
        ERROR
    }

    companion object {
        fun <T> success(data: T): Response<T> =
            Response(
                status = Status.SUCCESS,
                data = data,
                message = null
            )

        fun <T> loading(data: T? = null): Response<T> =
            Response(
                status = Status.LOADING,
                data = data,
                message = null
            )

        fun <T> error(message: String, data: T? = null): Response<T> =
            Response(
                status = Status.ERROR,
                data = data,
                message = message
            )
    }
}