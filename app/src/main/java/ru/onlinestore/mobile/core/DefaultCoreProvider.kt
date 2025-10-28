package ru.onlinestore.mobile.core

import android.content.Context

class DefaultCoreProvider(
    private val context: Context
): CoreProvider {
    override val resources = object: Resources {
        override fun string(res: Int) = context.getString(res)
    }
}