package com.maestre.ejerciciosbutton

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.maestre.ejerciciosbutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnValidate.setOnClickListener {
            val password = binding.ettPassword.text.toString()
            validatePassword(password)
        }

    }
    fun validatePassword(password: String){

        if(password == "abc123"){
            val intent = Intent(this, NuevaActividad::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Password incorrecta", Toast.LENGTH_SHORT).show()
        }
    }
}