package ru.onlinestore.mobile.data.sources.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpStatusCode
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.core.networkExceptionWrapper
import ru.onlinestore.mobile.data.entities.MessageData
import ru.onlinestore.mobile.data.entities.ResultListData
import ru.onlinestore.mobile.data.entities.UserData
import ru.onlinestore.mobile.data.entities.auth.LogInRequestBodyData
import ru.onlinestore.mobile.data.entities.auth.LogInResponseBodyData
import ru.onlinestore.mobile.data.entities.auth.RefreshResponseBodyData
import ru.onlinestore.mobile.data.entities.resources.AuthRes
import ru.onlinestore.mobile.data.entities.resources.UsersRes
import ru.onlinestore.mobile.data.sources.UserRemoteSource

class UserRemoteSourceImpl(private val client: HttpClient): UserRemoteSource {

    override suspend fun logIn(login: LogInRequestBodyData) =
        networkExceptionWrapper {
            val post = client.post(AuthRes.Login) { setBody(login) }

            when(post.status) {
                HttpStatusCode.OK -> Response.Success(post.body<LogInResponseBodyData>())
                HttpStatusCode.BadRequest -> Response.Invalid(post.body<MessageData>())
                else -> Response.Unknow
            }
        }

    override suspend fun me() =
        networkExceptionWrapper {
            val get = client.get(AuthRes.Me)

            when(get.status) {
                HttpStatusCode.OK -> Response.Success(get.body<UserData>())
                HttpStatusCode.Unauthorized -> Response.Invalid(get.body<MessageData>())
                else -> Response.Unknow
            }
        }

    override suspend fun refresh() =
        networkExceptionWrapper {
            val post = client.post(AuthRes.Refresh)

            when(post.status) {
                HttpStatusCode.OK -> Response.Success(post.body<RefreshResponseBodyData>())
                HttpStatusCode.Unauthorized -> Response.Invalid(post.body<MessageData>())
                else -> Response.Unknow
            }
        }

    override suspend fun fetchUserList() =
        networkExceptionWrapper {
            val get = client.get(UsersRes)

            when(get.status) {
                HttpStatusCode.OK -> Response.Success(get.body<ResultListData<UserData>>())
                else -> Response.Unknow
            }
        }

    override suspend fun findUserByID(id: Int) =
        networkExceptionWrapper {
            val get = client.get(UsersRes.User(id))

            when(get.status) {
                HttpStatusCode.OK -> Response.Success(get.body<UserData>())
                HttpStatusCode.NotFound -> Response.Invalid(get.body<MessageData>())
                else -> Response.Unknow
            }
        }

    override suspend fun searchUserByName(text: String) =
        networkExceptionWrapper {
            val get = client.get(UsersRes.Search(text))

            when(get.status) {
                HttpStatusCode.OK -> Response.Success(get.body<UserData>())
                HttpStatusCode.NotFound -> Response.Invalid(get.body<MessageData>())
                else -> Response.Unknow
            }
        }
}