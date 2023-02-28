package edu.wccnet.gadrake.p04_namesavedataproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wccnet.gadrake.p04_namesavedataproject2.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}