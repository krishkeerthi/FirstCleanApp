package com.example.firstcleanapp.framework

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import com.example.core.data.RecordRepository
import com.example.core.interactors.GetRecord
import com.example.core.interactors.GetRecords
import com.example.core.interactors.InsertRecord
import com.example.firstcleanapp.framework.db.RecordLocalDataSource

class FirstCleanAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        val recordRepository = RecordRepository(RecordLocalDataSource(this))

        Log.d(TAG, "onCreate: inject application class calling inject")
        FirstCleanAppViewModelFactory.inject(
            this,
            Interactors(
                InsertRecord(recordRepository),
                GetRecord(recordRepository),
                GetRecords(recordRepository)
            )
        )
    }
}