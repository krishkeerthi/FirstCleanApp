package com.example.firstcleanapp.framework

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object FirstCleanAppViewModelFactory: ViewModelProvider.Factory {

    private lateinit var application: Application
    private lateinit var interactors: Interactors

    fun inject(application: Application, interactors: Interactors){
        Log.d(TAG, "inject: application initialized")
        FirstCleanAppViewModelFactory.application = application
        FirstCleanAppViewModelFactory.interactors = interactors
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(FirstCleanAppViewModel::class.java.isAssignableFrom(modelClass)){
            Log.d(TAG, "create: inject inside factory which is using application")
            return modelClass.getConstructor(Application::class.java, Interactors::class.java)
                .newInstance(
                    application,
                    interactors
                )
        }
        else{
            throw java.lang.IllegalStateException("Viewmodel must extend FirstCleanAppViewModel")
        }
    }
}