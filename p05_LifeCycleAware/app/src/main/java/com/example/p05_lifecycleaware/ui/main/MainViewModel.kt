package com.example.p05_lifecycleaware.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : ViewModel() {

    companion object {
        var output: MutableLiveData<String> = MutableLiveData()

        fun addLifecycleOutputLine(stateFunction: String, endOfSet: Boolean) {

            val currentTime = SimpleDateFormat("hh:mm:ss.SSS").format(Calendar.getInstance().time)
            val newOutputLine = "$stateFunction was fired on " + currentTime

            if (output.value == null) {
                output.value = newOutputLine
            } else {
                output.value += "\n" + newOutputLine
            }

            if (endOfSet) output.value += "\n*****"

        }
    }

}