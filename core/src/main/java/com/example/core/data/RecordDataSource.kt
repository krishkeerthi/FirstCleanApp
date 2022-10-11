package com.example.core.data

import com.example.core.domain.Record

interface RecordDataSource {
    suspend fun getRecords(): List<Record>?

    suspend fun insertRecord(record: Record): Int

    suspend fun getRecord(id: Int): Record?
}