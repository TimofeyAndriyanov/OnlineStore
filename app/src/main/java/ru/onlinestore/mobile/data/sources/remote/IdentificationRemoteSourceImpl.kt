package ru.onlinestore.mobile.data.sources.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpStatusCode
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.data.entities.MessageData
import ru.onlinestore.mobile.data.entities.UserListData
import ru.onlinestore.mobile.data.entities.auth.AuthRequestBodyData
import ru.onlinestore.mobile.data.entities.auth.AuthResponseBodyData
import ru.onlinestore.mobile.data.sources.IdentificationRemoteSource

class IdentificationRemoteSourceImpl(private val client: HttpClient): IdentificationRemoteSource {
    override suspend fun authorization(auth: AuthRequestBodyData): Response<AuthResponseBodyData, MessageData> =
        try {
            val post = client.post(urlString = "user/login") { setBody(auth) }
            when(post.status) {
                HttpStatusCode.OK -> Response.Success(data = post.body())

                HttpStatusCode.BadRequest -> Response.Invalid(data = post.body())

                else -> Response.Empty
            }
        } catch (exception: Exception) { Response.Error(exception = exception) }

    override suspend fun fetchUserList(): Response<UserListData, Nothing> =
        try {
            val get = client.get(urlString = "users")
            Response.Success(data = get.body())
        } catch (exception: Exception) { Response.Error(exception = exception) }
}