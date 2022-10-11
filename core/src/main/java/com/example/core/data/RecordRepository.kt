package com.example.core.data

import com.example.core.domain.Record

class RecordRepository(private val dataSource: RecordDataSource) {
    suspend fun getRecords(): List<Record>?{
        return dataSource.getRecords()
    }

    suspend fun insertRecord(record: Record): Int{
        return dataSource.insertRecord(record)
    }

    suspend fun getRecord(id: Int): Record? {
        return dataSource.getRecord(id)
    }
}