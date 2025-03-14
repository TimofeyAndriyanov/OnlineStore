package ru.onlinestore.mobile.domain.repository

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.entities.MessageDomain
import ru.onlinestore.mobile.domain.entities.UserListDomain
import ru.onlinestore.mobile.domain.entities.auth.AuthRequestBodyDomain
import ru.onlinestore.mobile.domain.entities.auth.AuthResponseBodyDomain

interface IdentificationRepository {

    suspend fun authorization(auth: AuthRequestBodyDomain): Response<AuthResponseBodyDomain, MessageDomain>

    suspend fun fetchUserList(): Response<UserListDomain, Nothing>
}