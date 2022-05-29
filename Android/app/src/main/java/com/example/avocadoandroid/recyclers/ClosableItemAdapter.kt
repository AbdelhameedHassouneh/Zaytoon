package com.example.avocadoandroid.recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.avocadoandroid.R
import com.example.avocadoandroid.entities.ClosableClass

class ClosableItemAdapter() : ListAdapter<ClosableClass, ClosableItemViewHolder>(CountryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClosableItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.closable_item, parent, false)
        return ClosableItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClosableItemViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country)
    }

}

object CountryDiffCallback : DiffUtil.ItemCallback<ClosableClass>() {
    override fun areItemsTheSame(oldItem: ClosableClass, newItem: ClosableClass): Boolean {
        return oldItem.text == newItem.text
    }
    override fun areContentsTheSame(oldItem: ClosableClass, newItem: ClosableClass): Boolean {
        return oldItem.text == newItem.text && oldItem.image == newItem.image
    }
}