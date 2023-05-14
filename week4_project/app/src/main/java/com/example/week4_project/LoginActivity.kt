package com.example.week4_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week4_project.databinding.ActivityLoginBinding
import com.example.week4_project.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root

        super.onCreate(savedInstanceState)
        setContentView(view)

        binding.loginBtn.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            val login_name_et = binding.loginNameEt
            val login_id_et = binding.loginIdEt
            val login_pw_et = binding.loginPwEt
            intent.putExtra("user_name", login_name_et.text.toString())
            intent.putExtra("user_id", login_id_et.text.toString())
            intent.putExtra("user_pw", login_pw_et.text.toString())
            startActivity(intent)
            finish()
        }

    }
}