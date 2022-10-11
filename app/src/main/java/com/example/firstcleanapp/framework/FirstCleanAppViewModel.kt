package com.example.firstcleanapp.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class FirstCleanAppViewModel(application: Application, protected val interactors: Interactors) :
    AndroidViewModel(application) {

        protected val application: FirstCleanAppApplication = getApplication()

}