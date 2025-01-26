package com.ejemplo.recyclerviewimages

import adapter.AdaptadorImagenes
import adapter.ImagenesProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.ejemplo.recyclerviewimages.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuramos el RecyclerView
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvImages.layoutManager = manager
        // Para el efecto de "snap"
        // efecto de carrusel donde los elementos se centran automáticamente al visualizarlos
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvImages)
        
        binding.rvImages.adapter = AdaptadorImagenes(ImagenesProvider.imagenesList)

        // Crear un DividerItemDecoration y agregarlo al RecyclerView
        //val decoration = DividerItemDecoration(this, manager.orientation)
        //binding.rvImages.addItemDecoration(decoration)


    }
}