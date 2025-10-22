package ru.onlinestore.mobile.data.sources.locale.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.onlinestore.mobile.data.sources.locale.entities.UserDB

@Database(
    entities = [
        UserDB::class
    ],
    version = 1,
    exportSchema = false
)
abstract class OnlineStoreDatabase: RoomDatabase() {
    abstract fun userDAO(): UserDAO
}