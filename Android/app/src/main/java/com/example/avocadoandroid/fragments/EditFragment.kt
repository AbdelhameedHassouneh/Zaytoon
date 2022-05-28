package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentEditBinding
import com.example.avocadoandroid.entities.User
import com.example.avocadoandroid.models.UserSharedViewModel

class EditFragment : Fragment(R.layout.fragment_edit) {
    private lateinit var viewModel: UserSharedViewModel
    private lateinit var binding: FragmentEditBinding
    private lateinit var genderSpinner: Spinner

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
        val view = super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: fuckckck")
        genderSpinner = binding.spinnerGenderEditFragment
        binding.buttonNextEditFragment.setOnClickListener {
            try {
                val height = binding.editTextHeightEditFragment.text.toString().toInt()
                val weight:Double = binding.editTextWeightEditFragment.text.toString().toDouble()
                val age:Int = binding.editTextAgeEditFragment.text.toString().toInt()
                val gender:String = binding.spinnerGenderEditFragment.selectedItem.toString()
                val user: User = User(weight = weight,height = height.toDouble(), gender = gender,age = age)
                Log.d(TAG, "onCreate: $user")
            }catch (e:Exception){
                Toast.makeText(requireContext(), "Please Fill all the fields", Toast.LENGTH_LONG).show()

            }


        }


    }

    companion object {
        private const val TAG = "EditFragment"
    }

}