package edu.wccnet.gadrake.p03_namesavedataproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wccnet.gadrake.p03_namesavedataproject.R
import edu.wccnet.gadrake.p03_namesavedataproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    // TODO: what is these for agane?
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.namesText.text = viewModel.getNames()

        binding.addNameButton.setOnClickListener {
            if (binding.nameInput.text.isNotEmpty()) {
                viewModel.addNameToList(binding.nameInput.text.toString())
                binding.namesText.text = viewModel.getNames()
            } else {
                binding.namesText.text = "No Value"
            }
        }
    }

}