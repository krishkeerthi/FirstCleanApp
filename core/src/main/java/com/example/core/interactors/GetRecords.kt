package com.example.core.interactors

import com.example.core.data.RecordRepository
import com.example.core.domain.Record

class GetRecords(private val recordRepository: RecordRepository) {
    suspend operator fun invoke(): List<Record>?{
        return recordRepository.getRecords()
    }
}