package com.maestre.wisdompills

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maestre.wisdompills.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{
            val intent = Intent(this, ActividadRegistro::class.java)
            startActivity(intent)
        }
        binding.btnLoggeo.setOnClickListener{
            val intent = Intent(this, ActividadLoggeo::class.java)
            startActivity(intent)
        }

    }

}