package com.example.week3project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.week3project.databinding.MainCategoryListItemBinding
import java.text.FieldPosition

class MainCategoryAdapter(val category :List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder =
        MainCategoryHolder(MainCategoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // val view = LayoutInflater.from(MainCategoryListItemBinding.context).inflate(R.layout.main_category_list_item, parent, false)
        val binding = (holder as MainCategoryHolder).binding
        binding.mainCategoryBtn.setImageResource(category[position])
    }

    override fun getItemCount(): Int = category.size

}

