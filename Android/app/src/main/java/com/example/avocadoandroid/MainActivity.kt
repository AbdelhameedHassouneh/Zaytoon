package com.example.avocadoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.avocadoandroid.databinding.ActivityMainBinding
import com.example.avocadoandroid.models.LogInModel

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val viewModel:LogInModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AvocadoAndroid)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as MyApplication).getComponent().inject(viewModel)

        binding.logInButton.setOnClickListener{
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            viewModel.loginButton(email,password)
        }

    }
}