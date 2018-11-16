package com.tomberghuis.pushups.data

import android.content.Context
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase

@Database(
    version = 1, entities = [
        // list DB entities
        CompletedPushupSet::class
    ]
)
abstract class AppDatabase : RoomDatabase() {


    abstract fun completedPushupSetDao(): CompletedPushupSetDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(
                context.applicationContext, AppDatabase::class.java, "app-database"
            ).build()
    }

}