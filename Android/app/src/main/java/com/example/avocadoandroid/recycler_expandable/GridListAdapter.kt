package com.example.avocadoandroid.recycler_expandable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.ChildListItemBinding
import com.example.avocadoandroid.entities.DataHolder
import com.example.avocadoandroid.recyclers.ClosableItemViewHolder

class GridListAdapter(private val onItemClicked: (String) -> Unit) :
    ListAdapter<ChildItem, ChildViewHolder>(object : DiffUtil.ItemCallback<ChildItem>() {
        override fun areItemsTheSame(oldItem: ChildItem, newItem: ChildItem) =
            oldItem.foodItem == newItem.foodItem

        override fun areContentsTheSame(oldItem: ChildItem, newItem: ChildItem) =
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