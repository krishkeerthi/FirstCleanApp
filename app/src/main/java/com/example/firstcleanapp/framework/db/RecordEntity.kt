package com.example.firstcleanapp.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record_entity")
data class RecordEntity(
    val name: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "record_id")
    var recordId: Int = 0
}
