package com.example.classwork3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork3.databinding.ListItemBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var data: List<ItemData>

    fun setData(dt: List<ItemData>){
        if(!this::data.isInitialized)
            this.data = dt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(!this::data.isInitialized)
            return

        holder.icon.setBackgroundResource(data[position].icon)
        holder.text.text = data[position].text
        holder.icon2.setBackgroundResource(data[position].icon2)
        if(data[position].color != 0)
            holder.text.setTextColor(data[position].color)

    }

    override fun getItemCount(): Int {
        if(!this::data.isInitialized)
            return 0
        return data.size
    }

    inner class ViewHolder(binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        val icon = binding.icon
        val text = binding.text
        val icon2 = binding.icon2
    }
}