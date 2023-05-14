package com.example.week5_project

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week5_project.databinding.ActivityMainBinding
import com.example.week5_project.model.WeatherResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val APP_KEY = "3b8266d821a4f42e1d50b1a1f8c1ef40"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            getWeatherData(binding.editText.text.toString(), APP_KEY)
        }

    }

    private fun getWeatherData(city: String, key: String) {
        //retrofit 인터페이스 가져오기
        val weatherDataInterface = RetrofitClient.sRetrofit.create(RetrofitInterface::class.java)
        weatherDataInterface.getWeatherData(city, key).enqueue(object :retrofit2.Callback<WeatherResponse>{
            override fun onResponse(                    // response 가 제대로 불러왔을 때
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if(response.isSuccessful) {
                    val result = response.body() as WeatherResponse
                    binding.textView.text = result.main.temp.toString()+"도"
                } else {
                    Log.d(TAG, "통신실패 - onResponse() called")
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {         // 서버통신 실패했을 때
                Log.d(TAG, "통신실패 - onFailure() called")
            }

        })
    }
}