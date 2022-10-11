package com.example.firstcleanapp.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: RecordEntity): Long

    @Query("SELECT * FROM record_entity")
    suspend fun getRecords(): List<RecordEntity>?

    @Query("SELECT * FROM record_entity WHERE record_id = :id")
    suspend fun getRecord(id: Int): RecordEntity?
}