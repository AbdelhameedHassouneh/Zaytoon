package com.example.avocadoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.avocadoandroid.databinding.ActivityTabsBinding

class TabsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTabsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AvocadoAndroid)
        setContentView(R.layout.activity_tabs)


        binding = DataBindingUtil.setContentView(this,R.layout.activity_tabs)



    }
}