package ru.onlinestore.mobile.domain

import ru.onlinestore.mobile.data.entities.auth.LogInRequestBodyData
import ru.onlinestore.mobile.domain.entities.CategoryDomain
import ru.onlinestore.mobile.domain.entities.MessageDomain
import ru.onlinestore.mobile.domain.entities.ProductDomain
import ru.onlinestore.mobile.domain.entities.RefreshResponseBodyDomain
import ru.onlinestore.mobile.domain.entities.ResultListDomain
import ru.onlinestore.mobile.domain.entities.UserDomain
import ru.onlinestore.mobile.domain.entities.auth.LogInResponseBodyDomain
import ru.onlinestore.mobile.domain.entities.auth.LogInRequestBodyDomain
import ru.onlinestore.mobile.ui.entities.CategoryUI
import ru.onlinestore.mobile.ui.entities.MessageUI
import ru.onlinestore.mobile.ui.entities.RefreshResponseBodyUI
import ru.onlinestore.mobile.ui.entities.product.ProductUI
import ru.onlinestore.mobile.ui.entities.ResultListUI
import ru.onlinestore.mobile.ui.entities.user.UserUI
import ru.onlinestore.mobile.ui.entities.log_in.LogInRequestBodyUI
import ru.onlinestore.mobile.ui.entities.log_in.LogInResponseBodyUI

fun CategoryDomain.toUI() =
    CategoryUI(
        slug = slug,
        name = name,
        url = url
    )

fun MessageDomain.toUI() = MessageUI(message)

fun ProductDomain.toUI() =
    ProductUI(
        id = id,
        title = title,
        category = category,
        description = description,
        price = price,
        thumbnail = thumbnail,
        images = images
    )

fun ResultListDomain<ProductDomain>.toUI() =
    ResultListUI(
        result = result.map { it.toUI() },
        total = total,
        skip = skip,
        limit = limit
    )

fun UserDomain.toUI() =
    UserUI(
        id = id,
        image = image,
        username = username,
        password = password
    )

fun ResultListDomain<UserDomain>.toUI() =
    ResultListUI(
        result = result.map { it.toUI() },
        total = total,
        skip = skip,
        limit = limit
    )

fun LogInRequestBodyDomain.toData() =
    LogInRequestBodyData(username, password)

fun LogInRequestBodyUI.toDomain() =
    LogInRequestBodyDomain(username, password)

fun LogInResponseBodyDomain.toUI() =
    LogInResponseBodyUI(
        id = id,
        username = username,
        image = image,
        email = email,
        firstName = firstName,
        lastName = lastName,
        accessToken = accessToken,
        refreshToken = refreshToken
    )

fun RefreshResponseBodyDomain.toUI() =
    RefreshResponseBodyUI(accessToken, refreshToken)