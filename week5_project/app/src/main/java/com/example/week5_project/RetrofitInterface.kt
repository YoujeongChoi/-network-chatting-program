package com.example.week5_project

import com.example.week5_project.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("weather")        // 어떤 http 메소드인지 정의
    fun getWeatherData(@Query("q")q:String,
                       @Query("appid")appid:String) : Call<WeatherResponse>         // 보내는 방식 기입
                                                                                                                    // Querystring을 Query라고 한다
}