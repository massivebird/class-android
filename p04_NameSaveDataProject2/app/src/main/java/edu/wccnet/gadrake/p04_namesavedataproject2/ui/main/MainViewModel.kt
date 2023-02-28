package edu.wccnet.gadrake.p04_namesavedataproject2.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    var allNames: MutableLiveData<String> = MutableLiveData()
    var nameInput: MutableLiveData<String> = MutableLiveData()

    fun addNameToList() {
        nameInput.value.let {
            if (allNames.value == null) {
                allNames.value = it
            } else {
                allNames.value += "\n" + it
            }
        }
    }
}