package ru.onlinestore.mobile.data

import ru.onlinestore.mobile.data.entities.CategoryData
import ru.onlinestore.mobile.data.entities.MessageData
import ru.onlinestore.mobile.data.entities.ProductData
import ru.onlinestore.mobile.data.entities.ResultListData
import ru.onlinestore.mobile.data.entities.UserData
import ru.onlinestore.mobile.data.entities.auth.LogInResponseBodyData
import ru.onlinestore.mobile.data.entities.auth.RefreshResponseBodyData
import ru.onlinestore.mobile.domain.entities.CategoryDomain
import ru.onlinestore.mobile.domain.entities.MessageDomain
import ru.onlinestore.mobile.domain.entities.ProductDomain
import ru.onlinestore.mobile.domain.entities.RefreshResponseBodyDomain
import ru.onlinestore.mobile.domain.entities.ResultListDomain
import ru.onlinestore.mobile.domain.entities.UserDomain
import ru.onlinestore.mobile.domain.entities.auth.LogInResponseBodyDomain
import kotlin.collections.map

fun UserData.toDomain() =
    UserDomain(
        id = id,
        image = image,
        username = username,
        password = password
    )

fun ResultListData<UserData>.toDomain() =
    ResultListDomain(
        result = result.map { it.toDomain() },
        total = total,
        skip = skip,
        limit = limit
    )

fun ResultListData<ProductData>.toDomain() =
    ResultListDomain(
        result = result.map { it.toDomain() },
        total = total,
        skip = skip,
        limit = limit
    )

fun ProductData.toDomain() =
    ProductDomain(
        id = id,
        title = title,
        category = category,
        description = description,
        price = price,
        thumbnail = thumbnail,
        images = images
    )

fun MessageData.toDomain() = MessageDomain(message)

fun CategoryData.toDomain() =
    CategoryDomain(
        slug = slug,
        name = name,
        url = url
    )

fun List<CategoryData>.toDomain() = map { it.toDomain() }

fun LogInResponseBodyData.toDomain() =
    LogInResponseBodyDomain(
        id = id,
        username = username,
        image = image,
        email = email,
        firstName = firstName,
        lastName = lastName,
        accessToken = accessToken,
        refreshToken = refreshToken
    )

fun RefreshResponseBodyData.toDomain() =
    RefreshResponseBodyDomain(accessToken, refreshToken)