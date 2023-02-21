package edu.wccnet.gadrake.p03_namesavedataproject.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val noNamesText = "No names to display"
    private var allNames: String = ""

    fun addNameToList(name: String) {
<<<<<<< Updated upstream
=======
        // TODO: this works?
>>>>>>> Stashed changes
        allNames += if (allNames.isEmpty()) name
        else "\n" + name
    }

    fun getNames() : String {
        if (allNames.isEmpty()) return noNamesText
        return allNames
    }
}