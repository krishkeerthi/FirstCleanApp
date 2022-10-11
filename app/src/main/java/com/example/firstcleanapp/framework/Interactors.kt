package com.example.firstcleanapp.framework

import com.example.core.interactors.GetRecord
import com.example.core.interactors.GetRecords
import com.example.core.interactors.InsertRecord

data class Interactors(
    val insertRecord: InsertRecord,
    val getRecord: GetRecord,
    val getRecords: GetRecords
)
