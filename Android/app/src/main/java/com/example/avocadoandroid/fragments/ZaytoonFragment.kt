package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProviders
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentZaytoonBinding
import com.example.avocadoandroid.models.UserSharedViewModel

class ZaytoonFragment : Fragment(R.layout.fragment_zaytoon) {

    private lateinit var viewModel: UserSharedViewModel

    private lateinit var binding:FragmentZaytoonBinding
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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_zaytoon,container,false)
        binding.knowMoreText.setOnClickListener{
            parentFragmentManager.commit {
                replace<KnowMoreFragment>(R.id.fragment_container)
            }
        }

        binding.findYourNeedText.setOnClickListener {
            parentFragmentManager.commit {
                replace<CalculateFragment>(R.id.fragment_container)
            }
        }

        binding.lookForCalorieTextView.setOnClickListener {
            parentFragmentManager.commit {
                replace<LookFroCalorieAndNutFragment>(R.id.fragment_container)
            }
        }

        binding.makeTheBestChoiceText.setOnClickListener{
            parentFragmentManager.commit {
                replace<MakeTheBestChoiceFragment>(R.id.fragment_container)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userLiveData.observe(viewLifecycleOwner){
            binding.userNameText.text = "Hi ${it.firstName}"
        }
    }
}