package ru.onlinestore.mobile.data.sources.locale.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("users")
data class UserDB(
    @PrimaryKey(true)
    val id: Long = 0,
    val uid: Long,
    @ColumnInfo("access_token")
    val accessToken: String,
    @ColumnInfo("refresh_token")
    val refreshToken: String
)