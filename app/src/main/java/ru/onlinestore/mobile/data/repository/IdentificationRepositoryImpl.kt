package ru.onlinestore.mobile.data.repository

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.data.entities.MessageData
import ru.onlinestore.mobile.data.entities.auth.AuthResponseBodyData
import ru.onlinestore.mobile.data.sources.IdentificationRemoteSource
import ru.onlinestore.mobile.domain.entities.MessageDomain
import ru.onlinestore.mobile.domain.entities.UserListDomain
import ru.onlinestore.mobile.domain.entities.auth.AuthRequestBodyDomain
import ru.onlinestore.mobile.domain.entities.auth.AuthResponseBodyDomain
import ru.onlinestore.mobile.domain.repository.IdentificationRepository

class IdentificationRepositoryImpl(private val remote: IdentificationRemoteSource): IdentificationRepository {

    override suspend fun authorization(auth: AuthRequestBodyDomain): Response<AuthResponseBodyDomain, MessageDomain> =
        remote.authorization(
            auth = auth.toData()
        ).mapT { it: AuthResponseBodyData -> it.toDomain() }.mapI { it: MessageData -> it.toDomain() }

    override suspend fun fetchUserList(): Response<UserListDomain, Nothing> =
        remote.fetchUserList().mapT { it.toDomain() }
}