package com.example.week3project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.week3project.databinding.OrderedListItemBinding


class OrderedPagerAdapter (fa : FragmentActivity) : FragmentStateAdapter(fa){
    private val NUM_PAGES = 5

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ordered_frag01()
            1 -> ordered_frag02()
            2 -> ordered_frag03()
            3 -> ordered_frag04()
            else -> ordered_frag05()
        }
    }

}
