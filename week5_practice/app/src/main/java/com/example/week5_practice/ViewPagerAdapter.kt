package com.example.week5_practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week5_practice.databinding.ActivityMainBinding
import com.example.week5_practice.databinding.ItemLayoutBannerBinding
import com.example.week5_practice.databinding.MainFoodListItemBinding


class ViewPagerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val ITEM_COUNT = 5
    }

    private var bannerItemList: List<BannerItem>? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder  {
        return  BannerViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_banner, parent, false))

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            holder.setData(bannerItemList[position])
        }
    }


    override fun getItemCount(): Int = ITEM_COUNT




    //functions
    fun submitList(list: List<BannerItem>?) {
        bannerItemList = list
        notifyDataSetChanged()
    }

    
//    //ViewHolder
//    class BannerViewHolder
//        constructor (itemView : View) : RecyclerView.ViewHolder(itemView)
//    {
//        fun bind(bannerItem: BannerItem) {
//            itemView.iv_banner_image.setImageResource(bannerItem.image)
//        }
//

    }
}