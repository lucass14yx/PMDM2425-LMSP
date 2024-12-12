package com.maestre.recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maestre.recyclerview.databinding.ActivityDetallePlanetasBinding
import modelo.Planet
import modelo.PlanetData

class DetallePlanetas : AppCompatActivity() {
    val planets = PlanetData.getPlanets()
    private lateinit var binding: ActivityDetallePlanetasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePlanetasBinding.inflate(layoutInflater)
        setContentView(binding.main)

        val mlPlanetas: EditText = binding.mlPlanetas
        val btVolver: Button = binding.btVolver
        val selectedItems = intent.getIntegerArrayListExtra("selectedItems") ?: emptyList<Int>()

        // Access selected planets using selectedItems and display details
        val selectedPlanets = selectedItems.map { planets[it] } // Assuming 'planets' is accessible here
        // ... display details of selectedPlanets ...
        //Log.i("DetallePlanetas", "Selected planets: ${selectedPlanets}")
        val planetDetails = selectedPlanets.joinToString("\n") { planet ->
            "Nombre: ${planet.name}, Diametro: ${planet.sizeKm}, Distancia: ${planet.distanceAU}"
        }
        mlPlanetas.setText(planetDetails)
        btVolver.setOnClickListener {
            finish()
        }
    }
}