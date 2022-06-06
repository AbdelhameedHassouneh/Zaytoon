package com.example.avocadoandroid.recycler_expandable

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.avocadoandroid.databinding.ChildListItemBinding

class ChildViewHolder(
    private val binding: ChildListItemBinding,
    onChildClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            if (bindingAdapterPosition >= 0) {
                onChildClicked.invoke(bindingAdapterPosition)
            }
        }
    }

    fun bind(item: ChildItem) {

    }
}