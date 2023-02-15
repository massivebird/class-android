package edu.wccnet.gadrake.a38_fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wccnet.gadrake.a38_fragmentexample.databinding.ActivityMainBinding
// we need this
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), ToolbarFragment.ToolbarListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // called by ToolbarFragment...
    override fun onButtonClick(fontsize: Int, text: String) {
        // ... identifies TextFragment ...
        val textFragment = supportFragmentManager.findFragmentById(R.id.text_fragment) as TextFragment
        // ... calls TextFragment method to change its TextView properties
        textFragment.changeTextProperties(fontsize, text)
    }
}