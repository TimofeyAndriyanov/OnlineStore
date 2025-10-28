package ru.onlinestore.mobile.core

object Core {

    private lateinit var coreProvider: CoreProvider

    val resources get() = coreProvider.resources

    fun init(provider: CoreProvider) {
        coreProvider = provider
    }
}