package com.maestre.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import modelo.Planet
import com.maestre.recyclerview.adaptador.PlanetAdapter
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.maestre.recyclerview.databinding.ActivityMainBinding
import modelo.PlanetData

class MainActivity : AppCompatActivity() {
    val planets = PlanetData.getPlanets()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.main)

        val botonDetalle: Button = binding.btDetalle
        var  recyclerView: RecyclerView = binding.rvPlanetas
        recyclerView.layoutManager =  LinearLayoutManager(this)
        val planetAdapter= PlanetAdapter(planets)
        recyclerView.adapter = planetAdapter

        botonDetalle.setOnClickListener {

            //Toast.makeText(this, "Selected items: ${selectedItems}", Toast.LENGTH_SHORT).show()
            val selectedItems = planetAdapter.getSelectedItems()
            val intent = Intent(this, DetallePlanetas::class.java)

            intent.putIntegerArrayListExtra("selectedItems", ArrayList(selectedItems))
            startActivity(intent)
        }

    }

}