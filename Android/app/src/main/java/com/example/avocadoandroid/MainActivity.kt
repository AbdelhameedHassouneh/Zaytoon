package com.example.avocadoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.avocadoandroid.databinding.ActivityMainBinding
import com.example.avocadoandroid.models.LogInModel

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val viewModel:LogInModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AvocadoAndroid)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as MyApplication).getComponent().inject(viewModel)

        binding.logInButton.setOnClickListener{
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if(email.isBlank()||password.isBlank()){
                Toast.makeText(applicationContext, "Please fill all the fields", Toast.LENGTH_LONG).show()

            }else {
                viewModel.loginButton(email, password)
            }
        }

        binding.buttonSignUp.setOnClickListener{
            val intent:Intent = Intent(this,UserMeasurmentsActivity::class.java)
            startActivity(intent)
        }
        viewModel.user.observe(this ){
            if(it!=null){
                val intent:Intent = Intent(this,TabsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}