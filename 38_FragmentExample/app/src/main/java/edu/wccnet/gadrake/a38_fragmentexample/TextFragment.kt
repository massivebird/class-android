package edu.wccnet.gadrake.a38_fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import edu.wccnet.gadrake.a38_fragmentexample.databinding.FragmentTextBinding

class TextFragment : Fragment() {

    fun changeTextProperties(fontsize: Int, text: String) {
        binding.textView2.textSize = fontsize.toFloat()
        binding.textView2.text = text
    }

    private var _binding: FragmentTextBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_text, container, false)
        _binding = FragmentTextBinding.inflate(inflater, container, false)
        return binding.root
    }
}