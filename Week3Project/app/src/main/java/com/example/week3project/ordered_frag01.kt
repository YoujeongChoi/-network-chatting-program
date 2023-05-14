package com.example.week3project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week3project.databinding.OrderedFrag01Binding



class ordered_frag01 : Fragment() {

    private lateinit var mainAdapter : OrderedAdapter
    private lateinit var obinding: OrderedFrag01Binding
    private val binding get()  = obinding!!

    private val getOrderedList = arrayListOf(
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

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//        binding.orderedList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        binding.orderedList.setHasFixedSize(true)
//
//        binding.orderedList.adapter = OrderedAdapter(getOrderedList)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        obinding = OrderedFrag01Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.orderedList.setHasFixedSize(true)
        binding.orderedList.layoutManager = LinearLayoutManager(context)

//        binding.orderedList.apply {
//            this.adapter = OrderedAdapter(requiredContext(), )
//            setHasFixedSize(true)
//            val gridLayout = GridLayoutManager(context, 1)
//            layoutManager = gridLayout
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


}