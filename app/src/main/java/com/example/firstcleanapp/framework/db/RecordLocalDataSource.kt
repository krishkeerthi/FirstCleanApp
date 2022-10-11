package com.example.firstcleanapp.framework.db

import android.content.Context
import com.example.core.data.RecordDataSource
import com.example.core.domain.Record
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecordLocalDataSource(
    context: Context
): RecordDataSource {

    private val recordDao: RecordDao = FirstCleanDatabase.getInstance(context).recordDao()

    override suspend fun getRecords(): List<Record>? {
        return withContext(Dispatchers.IO){
            recordDao.getRecords()?.map {
                Record(it.name)
            }
        }
    }

    override suspend fun insertRecord(record: Record): Int {
        return withContext(Dispatchers.IO){
            recordDao.insert(RecordEntity(record.name)).toInt()
        }
    }

    override suspend fun getRecord(id: Int): Record? {
        return withContext(Dispatchers.IO){
            val recordEntity = recordDao.getRecord(id)
            recordEntity?.let {
                Record(recordEntity.name)
            }
        }
    }
}