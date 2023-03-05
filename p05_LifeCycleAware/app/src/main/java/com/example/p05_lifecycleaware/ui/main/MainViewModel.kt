package com.example.p05_lifecycleaware.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : ViewModel() {
    var output: MutableLiveData<String> = MutableLiveData()

    fun addLifecycleOutputLine(stateFunction: String) {
        val currentTime = SimpleDateFormat("hh:mm:s").format(Calendar.getInstance().time)
        val newOutputLine = "$stateFunction was fired " + currentTime
        if (output.value == null) {
            output.value = newOutputLine
        } else {
            output.value += "\n" + newOutputLine
        }
    }
}