package com.example.firstcleanapp.presentation.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.domain.Record
import com.example.firstcleanapp.framework.FirstCleanAppViewModel
import com.example.firstcleanapp.framework.Interactors
import kotlinx.coroutines.launch

class HomeFragmentViewModel(application: Application, interactors: Interactors)
    : FirstCleanAppViewModel(application, interactors) {

    private val _records= MutableLiveData<List<Record>?>()
    val records: LiveData<List<Record>?>
    get() = _records

    init {
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch {
            _records.value = interactors.getRecords()
        }
    }

    fun createRecord(addRecordToAdapter: (Record) -> Unit){
        viewModelScope.launch {
            val id = interactors.insertRecord(
                Record((1000..10000).random().toString())
            )

            val record: Record? = interactors.getRecord(id)

            record?.let {
                addRecordToAdapter(it)
            }

        }
    }
}
