package ru.onlinestore.mobile.data.sources

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.data.entities.MessageData
import ru.onlinestore.mobile.data.entities.UserListData
import ru.onlinestore.mobile.data.entities.auth.AuthRequestBodyData
import ru.onlinestore.mobile.data.entities.auth.AuthResponseBodyData

interface IdentificationRemoteSource {

    suspend fun authorization(auth: AuthRequestBodyData): Response<AuthResponseBodyData, MessageData>

    suspend fun fetchUserList(): Response<UserListData, Nothing>

}