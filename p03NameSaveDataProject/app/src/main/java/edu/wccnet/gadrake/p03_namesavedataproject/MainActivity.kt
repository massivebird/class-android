package edu.wccnet.gadrake.p03_namesavedataproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wccnet.gadrake.p03_namesavedataproject.ui.main.MainFragment

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