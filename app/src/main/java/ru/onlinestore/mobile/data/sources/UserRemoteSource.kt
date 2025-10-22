package ru.onlinestore.mobile.data.sources

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.data.entities.MessageData
import ru.onlinestore.mobile.data.entities.ResultListData
import ru.onlinestore.mobile.data.entities.UserData
import ru.onlinestore.mobile.data.entities.UserListData
import ru.onlinestore.mobile.data.entities.auth.LogInRequestBodyData
import ru.onlinestore.mobile.data.entities.auth.LogInResponseBodyData
import ru.onlinestore.mobile.data.entities.auth.RefreshResponseBodyData

interface UserRemoteSource {

    suspend fun logIn(login: LogInRequestBodyData): Response<LogInResponseBodyData, MessageData>

    suspend fun me(): Response<UserData, MessageData>

    suspend fun refresh(): Response<RefreshResponseBodyData, MessageData>

    suspend fun fetchUserList(): Response<ResultListData<UserData>, Nothing>

    suspend fun findUserByID(id: Int): Response<UserData, MessageData>

    suspend fun searchUserByName(text: String): Response<UserData, MessageData>
}