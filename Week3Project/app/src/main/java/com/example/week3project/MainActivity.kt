package com.example.week3project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week3project.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btmNavOrder.setOnClickListener {

            val intent = Intent(this, OrderedActivity::class.java)
            startActivity(intent)
        }


        val category = mutableListOf<Int>(
            R.drawable.main_menu_icon01,
            R.drawable.main_menu_icon02,
            R.drawable.main_menu_icon03,
            R.drawable.main_menu_icon04,
            R.drawable.main_menu_icon05,
            R.drawable.main_menu_icon06,
            R.drawable.main_menu_icon07,
            R.drawable.main_menu_icon08,
            R.drawable.main_menu_icon09,
            R.drawable.main_menu_icon10,
            R.drawable.main_menu_icon11,
            R.drawable.main_menu_icon12,
            R.drawable.main_menu_icon13,
            R.drawable.main_menu_icon14,
            R.drawable.main_menu_icon15
        )

        val layoutManager = GridLayoutManager(this, 5)
        binding.mainCategoryRv.layoutManager = layoutManager
        binding.mainCategoryRv.adapter = MainCategoryAdapter(category)

        val baemin1 = arrayListOf(
            MainBaemin1(R.drawable.baemin1_saeseoulchunggwa, "새서울청과", "4.8", "2,500원~3,500원"),
            MainBaemin1(R.drawable.bamin1_gookdae, "국대떡볶이길음역점", "4.7", "0원~700원"),
            MainBaemin1(R.drawable.baemin1_lasacheon, "라사천마라탕 장위점", "4.9", "1,000원~2,500원"),
            MainBaemin1(R.drawable.baemin1_bunzzukpizza, "번쩍피자", "4.9", "0원~1,000원"),
            MainBaemin1(R.drawable.baemin1_samgeorijok, "삼거리족발 직영점", "4.8", "2,000원"),
            MainBaemin1(R.drawable.baemin1_wangsipriyinsaeng, "왕십리인생곱창연탄구이", "4.9", "1,100원~3,000원")
        )

        val layoutManager_baemin = LinearLayoutManager(this)
        layoutManager_baemin.orientation = LinearLayoutManager.HORIZONTAL
        binding.mainBaemin1Rv.layoutManager = layoutManager_baemin
        binding.mainBaemin1Rv.adapter = MainBaemin1Adapter(baemin1)

        val food = arrayListOf(
            MainFood(R.drawable.food_myungzakpasta_01, R.drawable.food_myungzakpasta_02, R.drawable.food_myungzakpasta_03, "명작파스타 성북점", "5.0", "9,500원", "3,500원~4,000원"),
            MainFood(R.drawable.food_zipsin, R.drawable.food_no_img, R.drawable.food_no_img, "짚신매운갈비찜 본점", "4.8", "28,000원", "3,500원"),
            MainFood(R.drawable.food_hwarakbbq_01, R.drawable.food_hwarakbbq_02, R.drawable.food_hwarakbbq_03, "화락바베큐치킨 서울1호점", "5.0", "18,900원", "5,200원"),
            MainFood(R.drawable.food_doraegopchang_01, R.drawable.food_doraegopchang_02, R.drawable.food_doraegopchang_03, "도래곱창 미아점", "4.8", "5,000원", "0원~900원"),
            MainFood(R.drawable.food_ilsimhaejang_01, R.drawable.food_ilsimhaejang_02, R.drawable.food_no_img, "일심해장국", "4.5", "14,000원", "3,000원")
        )

        val layoutManager_food = LinearLayoutManager(this)
        layoutManager_food.orientation = LinearLayoutManager.VERTICAL
        binding.mainFoodRv.layoutManager = layoutManager_food
        binding.mainFoodRv.adapter = MainFoodAdapter(food)


    }
}


