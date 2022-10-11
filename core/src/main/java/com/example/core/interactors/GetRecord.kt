package com.example.core.interactors

import com.example.core.data.RecordRepository
import com.example.core.domain.Record

class GetRecord(private val recordRepository: RecordRepository) {

    suspend operator fun invoke(recordInt: Int): Record?{
        return recordRepository.getRecord(recordInt)
    }
}