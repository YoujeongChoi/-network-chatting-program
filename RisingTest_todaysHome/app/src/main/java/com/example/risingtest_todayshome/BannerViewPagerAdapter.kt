package com.example.risingtest_todayshome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.banner_ad_list_item.view.*

class BannerViewPagerAdapter(bannerAdList : ArrayList<Int> , fm: FragmentManager) : RecyclerView.Adapter<BannerViewPagerAdapter.PagerViewHolder>() {

    var item = bannerAdList

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.banner_ad_list_item, parent, false)){

        val banner = itemView.banner_ad_iv!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.banner.setImageResource(item[position])
    }

    override fun getItemCount(): Int = item.size
}