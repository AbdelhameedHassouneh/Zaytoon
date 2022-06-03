package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentEditBinding
import com.example.avocadoandroid.databinding.FragmentLookFroCalorieAndNutBinding
import com.example.avocadoandroid.models.UserSharedViewModel


class LookFroCalorieAndNutFragment : Fragment(R.layout.fragment_look_fro_calorie_and_nut) {
    private lateinit var viewModel: UserSharedViewModel
    private lateinit var binding: FragmentLookFroCalorieAndNutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[UserSharedViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_look_fro_calorie_and_nut, container, false)
        return binding.root
    }
}