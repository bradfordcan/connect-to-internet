package com.example.marsrealestate.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.marsrealestate.R
import com.example.marsrealestate.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.setLifecycleOwner(this)
        val marsProperty = DetailFragmentArgs.fromBundle(arguments!!).selectedProperty
        val detailViewModelFactory = DetailViewModelFactory(marsProperty, application)
        val viewModelFactory =
            ViewModelProviders.of(this, detailViewModelFactory).get(DetailViewModel::class.java)
        binding.viewModel = viewModelFactory
        return binding.root
    }
}