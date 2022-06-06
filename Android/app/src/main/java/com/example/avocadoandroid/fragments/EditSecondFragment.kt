package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentEditSecondBinding
import com.example.avocadoandroid.entities.User
import com.example.avocadoandroid.models.UserSharedViewModel


class EditSecondFragment : Fragment(R.layout.fragment_edit_second) {
    private lateinit var binding: FragmentEditSecondBinding
    private lateinit var userToEdit: User
    private lateinit var viewModel:UserSharedViewModel


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
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_second, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userToEditLiveData.observe(viewLifecycleOwner){
            userToEdit = it
        }

        binding.buttonEditProfile.setOnClickListener{
            try {
                val firstName: String = binding.editTextFirstName.text.toString()
                val lastName: String = binding.editTextLastName.text.toString()
                val email: String = binding.editTextEmail.text.toString()
                if(userToEdit!=null){
                    userToEdit!!.firstName = firstName
                    userToEdit!!.lastName = lastName
                    userToEdit!!.email = email
                    Log.d(TAG, "last step before calling $userToEdit")
                    viewModel.editProfile(userToEdit)
                }
            }catch (e: java.lang.Exception)
            {
                Log.d(TAG, "onCreate: errorrooror ${e.message}")
                Toast.makeText(requireContext(), "Please Fill all the fields", Toast.LENGTH_LONG).show()
            }
        }
    }
    companion object{
        private const val TAG = "EditSecondFragment"
    }
}