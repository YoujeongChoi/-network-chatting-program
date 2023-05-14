package com.example.risingtest_todayshome.HomePic

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HomePicRetrofitInterface {
    @GET("posts")
    fun getHomePicList() : Call<HomePicResponse>
}


