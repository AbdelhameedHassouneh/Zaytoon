package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentZaytoonBinding

class ZaytoonFragment : Fragment(R.layout.fragment_zaytoon) {

    private lateinit var binding:FragmentZaytoonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_zaytoon,container,false)
        return binding.root
    }


}