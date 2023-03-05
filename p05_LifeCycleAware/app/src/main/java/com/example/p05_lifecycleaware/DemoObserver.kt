package com.example.p05_lifecycleaware

import android.util.Log
import androidx.lifecycle.*
import com.example.p05_lifecycleaware.ui.main.MainViewModel

class DemoObserver: LifecycleObserver {

    private val LOG_TAG = "DemoObserver"
    private val viewModel = MainViewModel.Companion

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG, "onResume")
        viewModel.addLifecycleOutputLine("onResume", true)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG, "onPause")
        viewModel.addLifecycleOutputLine("onPause", true)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(LOG_TAG, "onCreate")
        viewModel.addLifecycleOutputLine("onCreate", false)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(LOG_TAG, "onStart")
        viewModel.addLifecycleOutputLine("onStart", false)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(LOG_TAG, "onStop")
        viewModel.addLifecycleOutputLine("onStop", false)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(LOG_TAG, "onDestroy")
        viewModel.addLifecycleOutputLine("onDestroy", true)
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
//        Log.i(LOG_TAG, owner.lifecycle.currentState.name)
//        viewModel.addLifecycleOutputLine("on" + owner.lifecycle.currentState.name)
//    }
}