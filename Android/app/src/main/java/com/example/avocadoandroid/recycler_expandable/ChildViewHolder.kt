package com.example.avocadoandroid.recycler_expandable

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.avocadoandroid.databinding.ChildListItemBinding
import com.example.avocadoandroid.utils.CategoryItem

class ChildViewHolder(
    private val binding: ChildListItemBinding,
    onChildClicked: (String) -> Unit

) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            onChildClicked.invoke(binding.foodItemText.text.toString())
        }
    }

    @SuppressLint("ResourceType")
    fun bind(item: CategoryItem) {
        binding.foodItemText.text = item.foodItem
        binding.subtitle.text = item.subTitle
        binding.sideNotes.text = item.sideNotes

        @DrawableRes val id:Int = binding.root.resources.getIdentifier(item.pictureName,"drawable",binding.root.context.packageName)
        binding.imageView4.setImageDrawable(binding.root.context.getDrawable(id))

    }
}