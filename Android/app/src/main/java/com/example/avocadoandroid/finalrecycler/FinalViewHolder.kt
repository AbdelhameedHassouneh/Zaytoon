package com.example.avocadoandroid.finalrecycler

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.avocadoandroid.databinding.FinalListItemSmallBinding
import com.example.avocadoandroid.utils.SizesInfo

class FinalViewHolder(private val binding: FinalListItemSmallBinding) :
    RecyclerView.ViewHolder(binding.root) {


    @SuppressLint("ResourceType")
    fun bind(item: SizesInfo) {

        if (item.calories != null && item.calories.compareTo("") != 0) {
            binding.caloriesTextView.text = "Calories: ${item.calories}"
        } else {
            binding.caloriesTextView.visibility = View.GONE
        }


        binding.carbsTextView.text = "Carb: ${item.carbs}"
        binding.fatsTextView.text = "Fats: ${item.fats}"
        binding.protien.text = "Protein: ${item.protein}"




        if (item.quantity != null && item.quantity.compareTo("") != 0) {
            binding.quantitiyTextView.text = "Quantity: ${item.quantity}"
        } else {
            binding.quantitiyTextView.visibility = View.GONE
        }


        if (item.food_size != null && item.food_size.compareTo("") != 0) {
            binding.foodSize.text = "Food Size: ${item.food_size}"
        } else {
            binding.foodSize.visibility = View.GONE
        }


    }
}