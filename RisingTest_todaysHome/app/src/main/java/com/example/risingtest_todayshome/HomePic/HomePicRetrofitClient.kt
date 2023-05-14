package com.example.risingtest_todayshome.HomePic

import android.app.TaskStackBuilder.create
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URI.create

object HomePicRetrofitClient {
    val sRetrofit = initRetrofit()
    private const val HOME_PIC_URL = "https://www.clapserver.shop/"

    private fun initRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(HOME_PIC_URL)                               // 앞에 바뀌지 않는 url
            .addConverterFactory(GsonConverterFactory.create()) // json을 java class로 만들어주는 factory
            .build() // 이렇게하면 비로소 retrofit 객체가 만들어짐

    val service_ct_tab : HomePicRetrofitInterface = initRetrofit().create(HomePicRetrofitInterface::class.java)
}

