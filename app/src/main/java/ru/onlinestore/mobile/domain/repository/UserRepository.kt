package ru.onlinestore.mobile.domain.repository

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.entities.MessageDomain
import ru.onlinestore.mobile.domain.entities.RefreshResponseBodyDomain
import ru.onlinestore.mobile.domain.entities.ResultListDomain
import ru.onlinestore.mobile.domain.entities.UserDomain
import ru.onlinestore.mobile.domain.entities.auth.LogInRequestBodyDomain
import ru.onlinestore.mobile.domain.entities.auth.LogInResponseBodyDomain

interface UserRepository {
    suspend fun logIn(login: LogInRequestBodyDomain): Response<LogInResponseBodyDomain, MessageDomain>

    suspend fun me(): Response<UserDomain, MessageDomain>

    suspend fun refresh(): Response<RefreshResponseBodyDomain, MessageDomain>

    suspend fun fetchUserList(): Response<ResultListDomain<UserDomain>, Nothing>

    suspend fun findUserByID(id: Int): Response<UserDomain, MessageDomain>

    suspend fun searchUserByName(text: String): Response<UserDomain, MessageDomain>
}