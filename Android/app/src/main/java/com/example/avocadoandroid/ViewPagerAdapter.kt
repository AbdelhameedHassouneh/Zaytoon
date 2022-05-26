package com.example.avocadoandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.avocadoandroid.entities.Tab

class ViewPagerAdapter(private var list: List<Tab>):RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val itemTitle:TextView = itemView.findViewById(R.id.title_item_page)
        val imageView:ImageView = itemView.findViewById(R.id.image_view_item_page)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page,parent,false))


   }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.imageView.setImageResource(list[position].image)
        holder.itemTitle.text = list[position].title
    }

    override fun getItemCount(): Int {
        return list.size
    }
}