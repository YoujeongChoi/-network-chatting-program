package com.example.week3project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week3project.databinding.MainFoodListItemBinding

class MainFoodAdapter(val category :ArrayList<MainFood>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder =
        MainFoodHolder(
            MainFoodListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MainFoodHolder).binding
        binding.mainFoodName.text = category.get(position).name.toString()
        binding.mainFoodScore.text = category.get(position).score.toString()
        binding.mainFoodTip.text = category.get(position).tip.toString()
        binding.imageView.setImageResource(category.get(position).img1)
        binding.imageView2.setImageResource(category.get(position).img2)
        binding.imageView3.setImageResource(category.get(position).img3)
    }

    override fun getItemCount(): Int = category.size

}
