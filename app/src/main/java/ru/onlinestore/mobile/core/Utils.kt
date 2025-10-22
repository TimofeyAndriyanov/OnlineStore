package ru.onlinestore.mobile.core

import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.ClientRequestException
import kotlinx.serialization.SerializationException
import ru.onlinestore.mobile.core.Response.Error.*
import kotlinx.io.IOException

suspend fun <SUCCESS, INVALID> networkExceptionWrapper(body: suspend () -> Response<SUCCESS, INVALID>) =
    try {
        body()
    } catch (e: ClientRequestException) {
        ClientRequest(e.response.status.value, e.message)
    } catch (e: ServerResponseException) {
        ServerResponse(e.response.status.value, e.message)
    } catch (e: IOException) {
        Io(e.message)
    } catch (e: SerializationException) {
        Serialization(e.message)
    }
