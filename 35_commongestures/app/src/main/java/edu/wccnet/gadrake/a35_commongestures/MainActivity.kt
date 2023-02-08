package edu.wccnet.gadrake.a35_commongestures

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import edu.wccnet.gadrake.a35_commongestures.databinding.ActivityMainBinding
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(),
    GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private lateinit var binding: ActivityMainBinding
    var gDetector: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.gDetector = GestureDetectorCompat(this, this)
        gDetector?.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        this.gDetector?.onTouchEvent(event)
        // gotta call superclass implementation
        return super.onTouchEvent(event)
    }

    @SuppressLint("SetTextI18n")
    override fun onDown(event: MotionEvent): Boolean {
        binding.gestureStatusText.text = "onDown"
        return true
    }

    @SuppressLint("SetTextI18n")
    override fun onShowPress(e: MotionEvent) {
        binding.gestureStatusText.text = "onShowPress"
    }

    @SuppressLint("SetTextI18n")
    override fun onSingleTapUp(e: MotionEvent): Boolean {
        binding.gestureStatusText.text = "onSingleTapUp"
        return true
    }

    @SuppressLint("SetTextI18n")
    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        binding.gestureStatusText.text = "onScroll"
        return true
    }

    @SuppressLint("SetTextI18n")
    override fun onLongPress(e: MotionEvent) {
        binding.gestureStatusText.text = "onLongPress"
    }

    @SuppressLint("SetTextI18n")
    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        binding.gestureStatusText.text = "onFling"
        return true
    }

    @SuppressLint("SetTextI18n")
    override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
        binding.gestureStatusText.text = "onSingleTapConfirmed"
        return true
    }

    @SuppressLint("SetTextI18n")
    override fun onDoubleTap(e: MotionEvent): Boolean {
        binding.gestureStatusText.text = "onDoubleTap"
        return true
    }

    @SuppressLint("SetTextI18n")
    override fun onDoubleTapEvent(e: MotionEvent): Boolean {
        binding.gestureStatusText.text = "onDoubleTapEvent"
        return true
    }
}