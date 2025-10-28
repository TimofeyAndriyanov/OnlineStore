package ru.onlinestore.mobile.core

import androidx.annotation.StringRes

interface Resources {
    fun string(@StringRes res: Int): String
}