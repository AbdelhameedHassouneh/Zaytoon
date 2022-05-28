package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentClosableBinding

class ClosableFragment : DialogFragment() {
    private lateinit var binding:FragmentClosableBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_closable,container,false)
        return binding.root
    }
}