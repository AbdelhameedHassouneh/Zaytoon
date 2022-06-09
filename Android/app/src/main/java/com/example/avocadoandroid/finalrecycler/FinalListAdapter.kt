package com.example.avocadoandroid.finalrecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.avocadoandroid.databinding.FinalListItemSmallBinding
import com.example.avocadoandroid.utils.SizesInfo

class FinalListAdapter() :
    ListAdapter<SizesInfo, FinalViewHolder>(object : DiffUtil.ItemCallback<SizesInfo>() {
        override fun areItemsTheSame(oldItem: SizesInfo, newItem: SizesInfo) =
            oldItem.calories == newItem.calories

        override fun areContentsTheSame(oldItem: SizesInfo, newItem: SizesInfo) =
            oldItem == newItem
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinalViewHolder {
        return FinalViewHolder(
            FinalListItemSmallBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FinalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}