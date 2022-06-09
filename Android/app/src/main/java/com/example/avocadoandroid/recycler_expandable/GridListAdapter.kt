package com.example.avocadoandroid.recycler_expandable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.avocadoandroid.databinding.ChildListItemBinding
import com.example.avocadoandroid.utils.CategoryItem


class GridListAdapter(private val onItemClicked: (string:String) -> Unit) :
    ListAdapter<CategoryItem, ChildViewHolder>(object : DiffUtil.ItemCallback<CategoryItem>() {
        override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem) =
            oldItem.foodItem == newItem.foodItem

        override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem) =
            oldItem == newItem
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(
            ChildListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),onItemClicked
        )
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}