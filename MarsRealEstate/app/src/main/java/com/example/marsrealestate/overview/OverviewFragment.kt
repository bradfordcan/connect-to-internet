package com.example.marsrealestate.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.marsrealestate.databinding.ItemGridViewBinding

class OverviewFragment : Fragment() {

    private lateinit var binding: ItemGridViewBinding

    // Lazy initialization
    private val overviewViewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflates layout with Data Binding
        binding = ItemGridViewBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this fragment
        binding.lifecycleOwner = this
        // Give binding access to the OverviewViewModel
        binding.viewModel = overviewViewModel
        return binding.root
    }
}