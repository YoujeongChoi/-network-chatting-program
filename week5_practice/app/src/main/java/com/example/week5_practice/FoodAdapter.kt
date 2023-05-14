package com.example.week5_practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.week5_practice.databinding.MainFoodListItemBinding

class FoodAdapter (val category: ArrayList<Food>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        RecyclerView.ViewHolder =
            FoodHolder(
                MainFoodListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as FoodHolder).binding
        binding.foodListAddress.text = category[position].foodList.address.toString()
        binding.foodListName.text = category[position].foodList.name.toString()
        binding.foodListScore.text = category[position].foodList.score.toString()
        binding.foodListCategory.text = category[position].foodList.category.toString()
        binding.foodListReview.text = category[position].foodList.review.toString()

        Glide.with(binding.foodListRl)
            .load(category[position].foodImg)
            // .placeholder(R.drawable.img_file_place_holder)
            .error(R.drawable.food_example)
            .fallback(R.drawable.food_example)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.foodListIv)
    }

    override fun getItemCount(): Int = category.size
}