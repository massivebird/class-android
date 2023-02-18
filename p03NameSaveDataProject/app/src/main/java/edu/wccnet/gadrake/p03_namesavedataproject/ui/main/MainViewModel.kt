package edu.wccnet.gadrake.p03_namesavedataproject.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private lateinit var allNames: String

    fun addNameToList(name: String) {

    }

    fun getNames() : String {
        return allNames
    }
}