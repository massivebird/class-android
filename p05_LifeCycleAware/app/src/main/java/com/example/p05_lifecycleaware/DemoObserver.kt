package com.example.p05_lifecycleaware

import androidx.lifecycle.*
import com.example.p05_lifecycleaware.ui.main.MainViewModel

class DemoObserver: DefaultLifecycleObserver {

    private val viewModel = MainViewModel.Companion

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        viewModel.addLifecycleOutputLine("onResume", true)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        viewModel.addLifecycleOutputLine("onPause", true)
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        viewModel.addLifecycleOutputLine("onCreate", false)
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        viewModel.addLifecycleOutputLine("onStart", false)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        viewModel.addLifecycleOutputLine("onStop", false)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        viewModel.addLifecycleOutputLine("onDestroy", true)
    }

}