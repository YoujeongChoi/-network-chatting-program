package com.example.week3project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.week3project.databinding.ActivityOrderedBinding

class OrderedViewPagerAdapter(val datas: MutableList<String>) : RecyclerView.Adapter<ViewHolder> () {

    var item = arrayListOf(
        R.drawable.ordered_ad_img1, R.drawable.ordered_ad_img2
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO()
        // RecyclerView.ViewHolder = OrderedViewHolder(ActivityOrderedBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val binding = (holder as OrderedViewHolder).binding
        when(position%2) {
            0 -> binding.orderedAdIb.setImageResource(item[position])
            else -> binding.orderedAdIb.setImageResource(item[position])
        }

    }

    override fun getItemCount(): Int {
       return datas.size
    }

}



