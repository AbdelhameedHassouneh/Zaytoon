package com.example.avocadoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.avocadoandroid.databinding.ActivityUserMeasurmentsBinding
import com.example.avocadoandroid.entities.User
import java.lang.Exception

class UserMeasurmentsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityUserMeasurmentsBinding
    private lateinit var spinner:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AvocadoAndroid)
        setContentView(R.layout.activity_user_measurments)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_measurments)

        spinner = binding.spinnerGender
        val list:List<String> = listOf("FEMALE","MALE")
        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter

        binding.buttonNext.setOnClickListener{
            Log.d("qqq", "onCreate: ${binding.editTextHeight.text.toString()}")

            try {


                val height:Int = binding.editTextHeight.text.toString().toInt()
                val weight:Double = binding.editTextWeight.text.toString().toDouble()
                val age:Int = binding.editTextAge.text.toString().toInt()
                val gender:String = binding.spinnerGender.selectedItem.toString()
                Log.d("qqq", "onCreate:$height ")

                val user:User = User(weight, height.toDouble(),gender,age)
                Log.d("qqq", "onCreate: $user")
                val intent:Intent = Intent(this,SignUpActivity::class.java)
                intent.putExtra("user",user)
                startActivity(intent)

            }catch (e:Exception){
                Toast.makeText(applicationContext, "Please Fill all the fields", Toast.LENGTH_LONG).show()
                Log.d("qqq", "onCreate: ${e.message}")

            }





        }


    }
}