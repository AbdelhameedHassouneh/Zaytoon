package com.example.avocadoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.avocadoandroid.databinding.ActivitySignUpBinding
import com.example.avocadoandroid.di.managers.UserManager
import com.example.avocadoandroid.entities.User
import com.example.avocadoandroid.models.LogInModel
import com.example.avocadoandroid.models.SignUpModel
import java.lang.Exception
import javax.inject.Inject


private const val TAG = "SignUpActivity"
class SignUpActivity : AppCompatActivity() {

    private val viewModel: SignUpModel by viewModels()

    private var user: User? = null
    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AvocadoAndroid)
        setContentView(R.layout.activity_sign_up)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_sign_up)
        (application as MyApplication).getComponent().inject(viewModel)

        user = intent.getSerializableExtra("user") as? User
        Log.d(TAG, "onCreate: $user")
        binding.buttonSignUp.setOnClickListener{
            try {
                val firstName: String = binding.editTextFirstName.text.toString()
                val lastName: String = binding.editTextLastName.text.toString()
                val email: String = binding.editTextEmail.text.toString()
                val password: String = binding.editTextPassword.text.toString()
                if(user!=null){
                    user!!.firstName = firstName
                    user!!.lastName = lastName
                    user!!.email = email
                    user!!.password = password
                    Log.d(TAG, "last step before calling $user")
                    viewModel.signUp(user!!)
                }
            }catch (e:Exception)
            {
                Log.d(TAG, "onCreate: errorrooror ${e.message}")
                Toast.makeText(this, "Please Fill all the fields", Toast.LENGTH_LONG).show()
            }
        }
        viewModel.user.observe(this){
            if(it!=null){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}