package com.example.avocadoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.avocadoandroid.entities.User

class SignUpActivity : AppCompatActivity() {
    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AvocadoAndroid)
        setContentView(R.layout.activity_sign_up)

        user = intent.getSerializableExtra("user") as? User
//        Log.d("qqq", "onCreate in sign up: $user")

    }
}