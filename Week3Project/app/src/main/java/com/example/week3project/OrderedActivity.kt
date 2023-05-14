package com.example.week3project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.week3project.databinding.ActivityOrderedBinding
import com.google.android.material.tabs.TabLayoutMediator


class OrderedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderedBinding


    private val tabTextList = arrayListOf(
        "배달/포장", "B마트", "배민스토어", "쇼핑라이브", "전국별미"
    )

    private var numBanner = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.orderedUpIb.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

         val ordered = arrayListOf(
        Ordered(R.drawable.ordered_bowpasta, "5일전ㆍ배달완료", "바우 파스타 미아본점", "찹 스테이크 샐러드 포케 1개 14,900원"),
        Ordered(R.drawable.ordered_nillipasta, "6일전ㆍ배달완료", "닐리파스타앤피자 북서울꿈의숲점", "알리오올리오 1개 14,500원"),
        Ordered(
            R.drawable.ordered_jaepal,
            "05/17 (화)ㆍ배달완료",
            "재팔이네닭발 대학로점",
            "(주문1위)매운 국물닭발(반조리) 1개 22,300원"
        ),
        Ordered(
            R.drawable.ordered_nillipasta,
            "05/03 (화)ㆍ배달완료",
            "닐리파스타앤피자 북서울꿈의숲점",
            "알리오올리오 1개 14,700원"
        ),
        Ordered(R.drawable.ordered_bongubeer, "04/30 (토)ㆍ배달완료", "봉구비어", "(Best)먹태구이 외 2개 32,500원"),
        Ordered(R.drawable.ordered_bowpasta, "5일전ㆍ배달완료", "바우 파스타 미아본점", "찹 스테이크 샐러드 포케 1개 14,900원"),
        Ordered(R.drawable.ordered_bowpasta, "5일전ㆍ배달완료", "바우 파스타 미아본점", "찹 스테이크 샐러드 포케 1개 14,900원"),
        Ordered(R.drawable.ordered_bowpasta, "5일전ㆍ배달완료", "바우 파스타 미아본점", "찹 스테이크 샐러드 포케 1개 14,900원"),
        Ordered(R.drawable.ordered_bowpasta, "5일전ㆍ배달완료", "바우 파스타 미아본점", "찹 스테이크 샐러드 포케 1개 14,900원"),
        Ordered(R.drawable.ordered_bowpasta, "5일전ㆍ배달완료", "바우 파스타 미아본점", "찹 스테이크 샐러드 포케 1개 14,900원")
    )

        val layoutManager_ordered = LinearLayoutManager(this)
        layoutManager_ordered.orientation = LinearLayoutManager.VERTICAL
        binding.orderedRv.layoutManager = layoutManager_ordered
        binding.orderedRv.adapter = OrderedAdapter(ordered)


    }
}



