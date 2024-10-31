package com.maestre.ejerciciosbutton

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maestre.ejerciciosbutton.databinding.ActivityNuevaActividadBinding

class NuevaActividad : AppCompatActivity() {
    private lateinit var binding: ActivityNuevaActividadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNuevaActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNewActivity.setOnClickListener {
            val intent = Intent(this, CuatroOps::class.java)
            startActivity(intent)

        }
    }

}