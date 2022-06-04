package com.example.avocadoandroid.recyclers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.avocadoandroid.R
import com.example.avocadoandroid.entities.DataHolder

class ClosableItemViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private val details: TextView = itemView.findViewById(R.id.text_in_closable_item)
    private val imageView: ImageView =itemView.findViewById(R.id.imageView3)

    private var current: DataHolder? = null


    fun bind(dataHolder: DataHolder) {
        current = dataHolder
        details.text = dataHolder.text
        imageView.setImageResource(R.drawable.logoo)

    }
}