package com.example.week3project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week3project.databinding.MainBaemin1ListItemBinding
import com.example.week3project.databinding.OrderedListItemBinding

class OrderedAdapter (val category : ArrayList<Ordered>): RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        OrderedHolder(OrderedListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as OrderedHolder).binding
        binding.orderedImg.setImageResource(category.get(position).img)
        binding.orderedDate.text = category.get(position).date
        binding.orderdName.text = category.get(position).name
        binding.orderedMenu.text = category.get(position).menu
    }

    override fun getItemCount(): Int = category.size

}