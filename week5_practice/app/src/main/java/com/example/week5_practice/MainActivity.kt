package com.example.week5_practice

import android.content.ContentValues.TAG

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.week5_practice.databinding.ActivityMainBinding
import com.example.week5_practice.foodImg.*
import com.example.week5_practice.foodImg.MainFoodImgAdapter
import com.example.week5_practice.foodList.*
// import com.example.week5_practice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ThreadLocalRandom
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var id = "vptSfobFaKbqhGD92XW2"
    private var secret = "uZ3rimjFFL"
    private var food_list_array = ArrayList<FoodList>()
    private var food_img_array = ArrayList<FoodImg>()
    private var food_array = ArrayList<Food>()
    var NUM_PAGES : Int = 5
    private var indexNum : Int = 0

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        var total = 5
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.setBannerItems(
            listOf(
                BannerItem(R.drawable.ad_img_01),
                BannerItem(R.drawable.ad_img_02),
                BannerItem(R.drawable.ad_img_03),
                BannerItem(R.drawable.ad_img_04),
                BannerItem(R.drawable.ad_img_05)
            )
        )

        initViewPager2()
        subscribeObservers()

        getFoodData(id, secret, "용산구 맛집", 5, 1)
        Log.d(TAG, "사이즈 ${food_list_array.size}")



//        for (i in 1 until total) {
//            getFoodData(id, secret, "용산구 맛집", 5, 1)
//            Log.d(TAG, "사이즈 ${food_list_array.size}")
//        }

    }

    private fun subscribeObservers() {
        viewModel.bannerItemList.observe(this, Observer { bannerItemList ->
            viewPagerAdapter.submitList(bannerItemList)
        })
    }

    private fun initViewPager2() {
        val viewPager2 = binding.mainAdViewpager
        viewPager2.apply {
            viewPagerAdapter = ViewPagerAdapter()
            binding.mainAdViewpager.adapter = viewPagerAdapter
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }


    private fun getFoodData(
        clientId: String,
        clientSecret: String,
        search: String,
        display: Int,
        start: Int
    ) {
        //retrofit 인터페이스 가져오기
        val weatherDataInterface =
            FoodListRetrofitClient.sRetrofit.create(FoodListRetrofitInterface::class.java)
        weatherDataInterface.getFoodListData(clientId, clientSecret, search, display, start)
            .enqueue(object :
                Callback<FoodResponse> {
                override fun onResponse(                    // response 가 제대로 불러왔을 때
                    call: Call<FoodResponse>,
                    response: Response<FoodResponse>
                ) {
                    if (response.isSuccessful) {
                        val result = response.body() as FoodResponse


                        for (i in 0 until result.items.size) {
                            var randomInteger = ThreadLocalRandom.current().nextInt(1, 100)
                            var review = randomInteger

                            var randomDouble = ThreadLocalRandom.current().nextDouble(1.0, 5.0)
                            var score = randomDouble
                            score = round(score * 100) / 100

                            var title = result.items[i].title
                            var varFoodList = FoodList(
                                result.items[i].address,
                                "${food_list_array.size + 1}. $title",
                                result.items[i].category,
                                score,
                                "(리뷰 $review)"
                            )
                            food_list_array.add(varFoodList)
                        }

//
                        Log.d(TAG, "사이즈확인용 ${food_list_array.size}")

                        for ( i in 0 until food_list_array.size) {
                            getFoodImgData(id, secret, "용산 ${food_list_array[i].name}", 1, "sim", "all")
                        }

                        Log.d(TAG, "음식점 데이터 통신성공 - onResponse() called")
                    } else {
                        Log.d(TAG, "음식점 데이터 통신실패 - onResponse() called")
                    }
                }

                override fun onFailure(
                    call: Call<FoodResponse>,
                    t: Throwable
                ) {         // 서버통신 실패했을 때
                    Log.d(TAG, "통신실패 - onFailure() called")
                }

            })
    }

    private fun getFoodImgData(
        clientId: String,
        clientSecret: String,
        query: String,
        display: Int,
        sort: String,
        filter: String
    ) {
        val FoodImgDataInterface =
            FoodImgRetrofitClient.fRetrofit.create(FoodImgRetrofitInterface::class.java)
        FoodImgDataInterface.getFoodImgData(clientId, clientSecret, query, display, sort, filter)
            .enqueue(object :
                Callback<FoodImgResponse> {
                override fun onResponse(
                    call: Call<FoodImgResponse>,
                    response: Response<FoodImgResponse>
                ) {
                    if (response.isSuccessful) {
                        val result = response.body()!!.items

                        var url = result[0].thumbnail
//                        for (i in 0 until display) {
//                            Log.d(TAG, "확인용 url - ${result.items.size}")
//                            Log.d(TAG, "확인용 url - $result.items[i].link")
//                            var url = result.items[i].link
//                            food_img_array.add(FoodImg(url))
//                        }
                        food_array.add(Food(url, food_list_array[indexNum]))

                        val adapter = FoodAdapter(food_array)
                        binding.mainListRv.layoutManager = GridLayoutManager(this@MainActivity, 2)                       // binding.mainListRv.layoutManager = LinearLayoutManager(this@MainActivity)
                        binding.mainListRv.adapter = adapter
                        adapter.notifyDataSetChanged()
                        Log.d(TAG, "이미지 통신성공 - onResponse() called ${food_img_array.size}")
                        indexNum++

                    } else {
                        Log.d(TAG, " 이미지 통신실패 - onResponse() called ${food_img_array.size}")
                    }
                }`

                override fun onFailure(
                    call: Call<FoodImgResponse>,
                    t: Throwable
                ) {         // 서버통신 실패했을 때
                    Log.d(TAG, "통신실패 - onFailure() called")
                }

            })
    }

    override fun onDestroy() {
        super.onDestroy()
        indexNum = 0


    }
}



