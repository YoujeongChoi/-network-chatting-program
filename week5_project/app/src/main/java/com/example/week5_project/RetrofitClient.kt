package com.example.week5_project

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val sRetrofit = initRetrofit()
    private const val WEATHER_URL = "https://api.openweathermap.org/data/2.5/"

    private fun initRetrofit() : Retrofit =
        Builder()
            .baseUrl(WEATHER_URL)                               // 앞에 바뀌지 않는 url
            .addConverterFactory(GsonConverterFactory.create()) // json을 java class로 만들어주는 factory
            .build()                                            // 이렇게하면 비로소 retrofit 객체가 만들어짐
}