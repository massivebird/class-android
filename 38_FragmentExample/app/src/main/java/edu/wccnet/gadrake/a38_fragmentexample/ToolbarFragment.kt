package edu.wccnet.gadrake.a38_fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
// inter-fragment communication
import android.widget.SeekBar
import android.content.Context

import edu.wccnet.gadrake.a38_fragmentexample.databinding.FragmentToolbarBinding

// ...                              below keeps track of that seekbar
class ToolbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var seekvalue = 10

    interface ToolbarListener {
        fun onButtonClick(position: Int, text: String)
    }

    private var activityCallback: ToolbarFragment.ToolbarListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            // this is used to call MAIN ACTIVITY METHOD(S) that will then pass
            // info to the other fragment
            activityCallback = context as ToolbarListener
        } catch (e: java.lang.ClassCastException) {
            throw ClassCastException(context.toString() + " must implement ToolbarListener")
        }
    }

    private var _binding: FragmentToolbarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_toolbar, container, false)
        _binding = FragmentToolbarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun buttonClicked(view: View) {
        // call main activity's onButtonClick() with the current input data
        activityCallback?.onButtonClick(seekvalue, binding.editTextTextPersonName.text.toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.seekBar.setOnSeekBarChangeListener(this)
        binding.button.setOnClickListener { v: View -> buttonClicked(v) }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        seekvalue = progress
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
}