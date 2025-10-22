package ru.onlinestore.mobile.data.entities.resources

import io.ktor.resources.Resource

@Resource("users")
data class UsersRes(val parent: RootRes = RootRes) {

    @Resource("{id}")
    data class User(val id: Int, val parent: UsersRes = UsersRes())
    @Resource("search?q={text}")
    data class Search(val text: String, val parent: UsersRes = UsersRes())
}