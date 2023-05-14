package com.example.risingtest_todayshome.HomePic

import com.example.risingtest_todayshome.Result

data class HomePicResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)