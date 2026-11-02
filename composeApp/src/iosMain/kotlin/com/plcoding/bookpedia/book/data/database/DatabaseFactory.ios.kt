@file:OptIn(ExperimentalForeignApi::class)

package com.plcoding.bookpedia.book.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<FavouriteBookDatabase> {
        val dbFile = documentDirectory() + "/${FavouriteBookDatabase.DB_NAME}"
        return Room.databaseBuilder<FavouriteBookDatabase>(
            name = dbFile
        )
    }

    private fun documentDirectory(): String{
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            craete = false,
            error = null
        )
        return requireNotNull(documentDirectory?.path)
    }
}