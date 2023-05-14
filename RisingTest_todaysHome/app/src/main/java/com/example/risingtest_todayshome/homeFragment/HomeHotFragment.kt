package com.example.risingtest_todayshome.homeFragment

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.risingtest_todayshome.BannerViewPagerAdapter
import com.example.risingtest_todayshome.R
import com.example.risingtest_todayshome.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home_hot.*
import kotlinx.android.synthetic.main.home_hot_jip_recommend_list_item.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeHotFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(ContentValues.TAG, "우왕hot - onCreate() called")

    }

    private fun getAdList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.banner_ad_img01, R.drawable.banner_ad_img02, R.drawable.banner_ad_img03, R.drawable.banner_ad_img04, R.drawable.banner_ad_img05)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_hot, container, false)

        val adViewPager = banner_ad_vp
        adViewPager.adapter = BannerViewPagerAdapter(getAdList(), childFragmentManager)
        adViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }




}