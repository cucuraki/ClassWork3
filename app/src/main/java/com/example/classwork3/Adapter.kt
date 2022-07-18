package com.example.classwork3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork3.databinding.LanguageLayoutBinding
import com.example.classwork3.databinding.ListItemBinding

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var data: List<ItemData>

    companion object {
        const val TYPE_FIRST = 1
        const val TYPE_SECOND = 2
    }

    fun setData(dt: List<ItemData>) {
        if (!this::data.isInitialized)
            this.data = dt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == 1) ViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context))
        ) else SecondViewHolder(
            LanguageLayoutBinding.inflate(LayoutInflater.from(parent.context))
        )


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (!this::data.isInitialized)
            return
        if(holder is ViewHolder) {
            holder.icon.setBackgroundResource(data[position].icon)
            holder.text.text = data[position].text
            holder.icon2.setBackgroundResource(data[position].icon2)
            if (data[position].color != 0)
                holder.text.setTextColor(data[position].color)
        }else if(holder is SecondViewHolder){
            holder.icon.setBackgroundResource(data[position].icon)
            holder.text.text = data[position].text
            holder.icon2.setBackgroundResource(data[position].icon2)
            holder.text2.text = data[position].secondText
        }
    }

    override fun getItemCount(): Int {
        if (!this::data.isInitialized)
            return 0
        return data.size
    }

    override fun getItemViewType(position: Int) = data[position].layoutType
    inner class ViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val icon = binding.icon
        val text = binding.text
        val icon2 = binding.icon2
    }

    inner class SecondViewHolder(binding: LanguageLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val icon = binding.icon
        val text = binding.text
        val icon2 = binding.icon2
        val text2 = binding.language
    }
}