package com.example.risingtest_todayshome.HomePic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.risingtest_todayshome.R
import com.example.risingtest_todayshome.databinding.HomeFollowingListItemBinding
import com.example.risingtest_todayshome.databinding.HomePictureListItemBinding
import com.example.risingtest_todayshome.homeFollowing.HomeFollowing
import com.example.risingtest_todayshome.homeFollowing.HomeFollowingHolder

class HomePicAdapter(val category :ArrayList<HomePicture>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            RecyclerView.ViewHolder =
        HomePicHolder(
            HomePictureListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val binding = (holder as HomePicHolder).binding

        binding.homePictureTv.text = category[position].title.toString()

        Glide.with(binding.homePicItemCl)
            .load(category[position].url)
            .error(R.drawable.sample_main_following_img02)
            .fallback(R.drawable.sample_main_following_img02)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.homePictureIv)
    }
    override fun getItemCount(): Int = category.size
}