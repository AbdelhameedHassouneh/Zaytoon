package com.example.avocadoandroid.recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.avocadoandroid.R
import com.example.avocadoandroid.entities.DataHolder

class ClosableItemAdapter() : ListAdapter<DataHolder, ClosableItemViewHolder>(CountryDiffCallback) {

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

object CountryDiffCallback : DiffUtil.ItemCallback<DataHolder>() {
    override fun areItemsTheSame(oldItem: DataHolder, newItem: DataHolder): Boolean {
        return oldItem.text == newItem.text
    }
    override fun areContentsTheSame(oldItem: DataHolder, newItem: DataHolder): Boolean {
        return oldItem.text == newItem.text && oldItem.image == newItem.image
    }
}