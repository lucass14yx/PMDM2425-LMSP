package com.maestre.calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maestre.calculator.databinding.ActivityActividadNuevaBinding
import com.maestre.calculator.databinding.ActivityMainBinding

class ActividadNueva : AppCompatActivity() {
    private lateinit var binding: ActivityActividadNuevaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadNuevaBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}