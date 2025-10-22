package ru.onlinestore.mobile.data.entities.resources

import io.ktor.resources.Resource

@Resource("auth")
data class AuthRes(val parent: RootRes = RootRes) {

    @Resource("login")
    data class Login(val parent: AuthRes = AuthRes())

    @Resource("me")
    data class Me(val parent: AuthRes = AuthRes())

    @Resource("refresh")
    data class Refresh(val parent: AuthRes = AuthRes())
}