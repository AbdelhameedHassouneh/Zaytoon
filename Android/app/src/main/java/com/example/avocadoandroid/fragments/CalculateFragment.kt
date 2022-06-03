package com.example.avocadoandroid.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentCalculateBinding
import com.example.avocadoandroid.entities.CaloriesDTO
import com.example.avocadoandroid.entities.User
import com.example.avocadoandroid.models.UserSharedViewModel


class CalculateFragment : Fragment(R.layout.fragment_calculate) {

    private lateinit var viewModel: UserSharedViewModel
    private lateinit var binding: FragmentCalculateBinding
    private lateinit var user: User

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calculate, container, false)
        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userLiveData.observe(viewLifecycleOwner){
            user = it
            binding.textViewAge.text = "${it.age}"
            binding.heightTextView.text = "${it.height.toInt()} CM"
            binding.textViewWeight.text = "${it.weight} KG"
            if(it.gender == ("FEMALE")){
                binding.femaleTextView.setTextColor(Color.parseColor("#FF3700B3"))
            }else{
                binding.maleTextView.setTextColor(Color.parseColor("#FF3700B3"))
            }
        }

        binding.button.setOnClickListener{
            val levelOfActSpinner:String = binding.spinner.selectedItem.toString()
            val levelOfAct:String = when(levelOfActSpinner){
                "Light exercise (1-3 days per week)"->"LIGTH"
                "Moderate exercise (3-5 days per week)"->"MODERATE"
                "Heavy exercise (6-7 days per week)"->"HIGH"
                "Very heavy exercise (twice per day)"->"VERY_HIGH"
                else -> {""}
            }
            val dto:CaloriesDTO = CaloriesDTO(user.age,user.height,user.weight,user.gender,levelOfAct)
            viewModel.calculateNeeds(dto)
        }
    }
}