package com.maestre.ejemplomvvm.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.maestre.ejemplomvvm.R
import com.maestre.ejemplomvvm.viewmodel.CitasViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recuperar viewModel
        val viewModel: CitasViewModel by viewModels()

        //Pintar pantallas
        val valorCita = findViewById<TextView>(R.id.tvCita)
        valorCita.text = viewModel.cita.cita

        val valorAutor = findViewById<TextView>(R.id.tvAutor)
        valorAutor.text = viewModel.cita.autor

    }
}