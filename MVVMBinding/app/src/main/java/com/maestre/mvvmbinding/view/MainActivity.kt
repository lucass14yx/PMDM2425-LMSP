package com.maestre.mvvmbinding.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.maestre.mvvmbinding.viewmodel.CitasViewModel
import com.maestre.mvvmbinding.R
import com.maestre.mvvmbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enlazar con layout usando binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar viewModel
        val viewModel: CitasViewModel by viewModels()

        //Pintar pantallas
        binding.tvCita.text = viewModel.cita.cita

       binding.tvAutor.text = viewModel.cita.autor

    }
}