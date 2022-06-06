package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentClosableBinding
import com.example.avocadoandroid.entities.DataHolder
import com.example.avocadoandroid.recyclers.ClosableItemAdapter

class ClosableFragment : DialogFragment() {
    private lateinit var binding:FragmentClosableBinding
    private lateinit var closableItemAdapter: ClosableItemAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_closable,container,false)
        closableItemAdapter = ClosableItemAdapter()
        val recyclerView = binding.closableRecycler
        closableItemAdapter.submitList(mutableListOf<DataHolder>(DataHolder(R.drawable.logoo,"textttt"),
            DataHolder(R.drawable.logoo,"qweqweqwe")))
        recyclerView.adapter = closableItemAdapter

        return binding.root
    }



}