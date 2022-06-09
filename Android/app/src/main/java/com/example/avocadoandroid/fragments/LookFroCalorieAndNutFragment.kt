package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.add
import androidx.lifecycle.ViewModelProviders
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentEditBinding
import com.example.avocadoandroid.databinding.FragmentLookFroCalorieAndNutBinding
import com.example.avocadoandroid.entities.DataHolder
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

        binding.streetFoodLay.titleTextView.text= "StreetFood"
        binding.streetFoodLay.catImageView.setImageResource(R.drawable.street_foods)
        binding.streetFoodLay.root.setOnClickListener{
            viewModel.setZaytoonCat("street_food")
            parentFragmentManager.commit {
                add<ExpandableFragment>(R.id.fragment_container)
                addToBackStack(null)
            }
        }

        binding.foodTrucksLay.titleTextView.text = "Food Trucks"
        binding.foodTrucksLay.catImageView.setImageResource(R.drawable.food_trucks)
        binding.foodTrucksLay.root.setOnClickListener{
            viewModel.setZaytoonCat("food_trucks")

            parentFragmentManager.commit {
                add<ExpandableFragment>(R.id.fragment_container)
                addToBackStack(null)
            }
        }

        binding.restaurantsLay.titleTextView.text = "Restaurants"
        binding.restaurantsLay.catImageView.setImageResource(R.drawable.resturants)
//        binding.restaurantsLay.root.setOnClickListener{
//            parentFragmentManager.commit {
//                add<ExpandableFragment>(R.id.fragment_container)
//                addToBackStack(null)
//            }
//        }

        binding.bakeriesLay.titleTextView.text = "Bakeries"
        binding.bakeriesLay.catImageView.setImageResource(R.drawable.bakeries)
//        binding.bakeriesLay.root.setOnClickListener{
//            parentFragmentManager.commit {
//                add<ExpandableFragment>(R.id.fragment_container)
//                addToBackStack(null)
//            }
//        }

        binding.sweetShopsLay.titleTextView.text = "Sweet shops"
        binding.sweetShopsLay.catImageView.setImageResource(R.drawable.sweets)
//        binding.sweetShopsLay.root.setOnClickListener{
//            parentFragmentManager.commit {
//                add<ExpandableFragment>(R.id.fragment_container)
//                addToBackStack(null)
//            }
//        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}