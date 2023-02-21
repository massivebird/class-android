package edu.wccnet.gadrake.a40_viewmodeldemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import edu.wccnet.gadrake.a40_viewmodeldemo.R
import edu.wccnet.gadrake.a40_viewmodeldemo.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // now handled by livedata;
        // auto updates textview on UI recreation via lifecycle observation
//        binding.resultText.text = viewModel.getResult().toString()

        // ch 41 livedata
        // implementing observer within UI controller (MainFragment.kt);
        // lambda is passed current result value -> converts to string -> displays in textview
        val resultObserver = Observer<Float> {
                result -> binding.resultText.text = result.toString()
        }
        viewModel.getResult().observe(viewLifecycleOwner, resultObserver)

        binding.convertButton.setOnClickListener {
            if (binding.dollarText.text.isNotEmpty()) {
                viewModel.setAmount(binding.dollarText.text.toString())
            } else {
                binding.resultText.text = "No value"
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}