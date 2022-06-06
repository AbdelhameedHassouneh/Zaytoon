package com.example.avocadoandroid.recycler_expandable

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.ParentListItemBinding


class ParentViewHolder(
    private val binding: ParentListItemBinding,
    onChildClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            if (bindingAdapterPosition > 0)
                onChildClicked.invoke(bindingAdapterPosition)
        }
    }

    fun bind(item: ExpandableItem) {
        val ctx = binding.root.context
        binding.textInParent.text = item.title
        val icon = if (item.isExpanded) {
            ContextCompat.getDrawable(
                ctx,
                R.drawable.ic_baseline_keyboard_arrow_down_24
            )
        } else {
            ContextCompat.getDrawable(ctx, R.drawable.ic_baseline_keyboard_arrow_up_24)
        }
        binding.imageViewInParent.setImageDrawable(
            ContextCompat.getDrawable(
                binding.root.context,
                item.icon
            )
        )
    }
}