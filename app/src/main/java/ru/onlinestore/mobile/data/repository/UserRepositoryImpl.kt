package ru.onlinestore.mobile.data.repository

import ru.onlinestore.mobile.data.sources.UserRemoteSource
import ru.onlinestore.mobile.data.toDomain
import ru.onlinestore.mobile.domain.entities.auth.LogInRequestBodyDomain
import ru.onlinestore.mobile.domain.repository.UserRepository
import ru.onlinestore.mobile.domain.toData

class UserRepositoryImpl(private val remote: UserRemoteSource): UserRepository {

    override suspend fun logIn(login: LogInRequestBodyDomain) =
        remote.logIn(login.toData()).mapSuccess { it.toDomain() }.mapInvalid { it.toDomain() }

    override suspend fun me() =
        remote.me().mapSuccess { it.toDomain() }.mapInvalid { it.toDomain() }

    override suspend fun refresh() =
        remote.refresh().mapSuccess { it.toDomain() }.mapInvalid { it.toDomain() }

    override suspend fun fetchUserList() =
        remote.fetchUserList().mapSuccess { it.toDomain() }

    override suspend fun findUserByID(id: Int) =
        remote.findUserByID(id).mapSuccess { it.toDomain() }.mapInvalid { it.toDomain() }

    override suspend fun searchUserByName(text: String) =
        remote.searchUserByName(text).mapSuccess { it.toDomain() }.mapInvalid { it.toDomain() }
}