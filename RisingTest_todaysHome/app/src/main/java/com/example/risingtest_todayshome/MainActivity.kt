package com.example.risingtest_todayshome

import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.risingtest_todayshome.databinding.ActivityMainBinding
import com.example.risingtest_todayshome.homeFragment.*
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home_hot.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context

    private val tabTitleArray = arrayOf(
        "인기",
        "팔로잉",
        "사진",
        "집들이",
        "노하우",
        "전문가집들이",
        "질문과답변"
    )

    private var numBanner = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.d(ContentValues.TAG, "우왕main - onCreate() called")
        // tab
        val viewPager = binding.mainViewpager
        val tabLayout = binding.mainTabs

        viewPager.adapter = PagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()




    }

    private fun getAdList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.banner_ad_img01, R.drawable.banner_ad_img02,  R.drawable.banner_ad_img03,  R.drawable.banner_ad_img04,  R.drawable.banner_ad_img05)
    }


}