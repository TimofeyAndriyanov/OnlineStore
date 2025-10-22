package ru.onlinestore.mobile.data.sources.locale.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import ru.onlinestore.mobile.data.sources.locale.entities.UserDB

@Dao
interface UserDAO {

    @Insert
    @Transaction
    suspend fun addUser(user: UserDB)

    @Query("SELECT * FROM users WHERE uid=:uid")
    @Transaction
    suspend fun findUserByUID(uid: Long): UserDB

    @Delete
    @Transaction
    suspend fun deleteUser(user: UserDB)
}