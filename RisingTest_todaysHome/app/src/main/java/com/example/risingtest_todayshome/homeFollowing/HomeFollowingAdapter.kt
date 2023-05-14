package com.example.risingtest_todayshome.homeFollowing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest_todayshome.databinding.HomeFollowingListItemBinding

class HomeFollowingAdapter (val category :ArrayList<HomeFollowing>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder =
        HomeFollowingHolder(HomeFollowingListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // val view = LayoutInflater.from(MainCategoryListItemBinding.context).inflate(R.layout.main_category_list_item, parent, false)
        val binding = (holder as HomeFollowingHolder).binding
        // binding.mainBaemin1Img.setImageResource(category.get(position).img)
        // binding.mainBaemin1Name.text = category.get(position).name.toString()
        // binding.mainBaemin1Score.text = category.get(position).score.toString()
        // binding.mainBaemin1Price.text = category.get(position).price.toString()
    }

    override fun getItemCount(): Int = category.size

}