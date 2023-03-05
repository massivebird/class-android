package com.example.p05_lifecycleaware

import android.util.Log
import androidx.lifecycle.*
import com.example.p05_lifecycleaware.ui.main.MainViewModel

class DemoObserver: LifecycleObserver {

    private val viewModel = MainViewModel.Companion

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        viewModel.addLifecycleOutputLine("onResume", true)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        viewModel.addLifecycleOutputLine("onPause", true)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        viewModel.addLifecycleOutputLine("onCreate", false)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        viewModel.addLifecycleOutputLine("onStart", false)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        viewModel.addLifecycleOutputLine("onStop", false)
    }

    fun onDestroy() {
        viewModel.addLifecycleOutputLine("onDestroy", true)
    }

}