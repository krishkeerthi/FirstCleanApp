package com.example.core.interactors

import com.example.core.data.RecordRepository
import com.example.core.domain.Record

class InsertRecord(private val recordRepository: RecordRepository) {
    suspend operator fun invoke(record: Record): Int{
        return recordRepository.insertRecord(record)
    }
}