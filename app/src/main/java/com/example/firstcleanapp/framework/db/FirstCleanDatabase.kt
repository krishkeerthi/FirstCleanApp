package com.example.firstcleanapp.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [RecordEntity::class],
    version = 1
)
abstract class FirstCleanDatabase: RoomDatabase(){

    abstract fun recordDao(): RecordDao

    companion object{
        @Volatile
        private var instance: FirstCleanDatabase? = null

        fun getInstance(context: Context): FirstCleanDatabase {
            return instance ?: synchronized(this){
                instance ?: buildDatabaseInstance(context).also{
                    instance = it
                }
            }
        }

        private fun buildDatabaseInstance(context: Context): FirstCleanDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                FirstCleanDatabase::class.java,
                "first_clean_database"
            ).build()
        }
    }
}