package com.example.week4_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week4_project.databinding.ActivityLoginBinding
import com.example.week4_project.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root


        super.onCreate(savedInstanceState)
        setContentView(view)


        binding.startLoginBtn.setOnClickListener {
            val intent = Intent(this, ActivityLoginBinding::class.java)
            startActivity(intent)
        }
    }
}