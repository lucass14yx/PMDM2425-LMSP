package com.maestre.wisdompills

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maestre.wisdompills.databinding.ActivityActividadRegistroBinding
import com.maestre.wisdompills.databinding.ActivityMainBinding

class ActividadRegistro : AppCompatActivity() {
    private lateinit var binding: ActivityActividadRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}