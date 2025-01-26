package com.example.recyclerviewejemplobasico

import adapter.AdaptadorCantantes
import adapter.CantanteProvider
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewejemplobasico.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuramos el RecyclerView
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        binding.rvCantantes.layoutManager = manager
        binding.rvCantantes.adapter = AdaptadorCantantes(CantanteProvider.cantantesList)

        // Crear un DividerItemDecoration y agregarlo al RecyclerView
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.rvCantantes.addItemDecoration(decoration)

        // Agregar un ScrollListener al RecyclerView para mostrar/ocultar las flechas
        binding.rvCantantes.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val visibleItemCount = layoutManager.childCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                // Mostrar la flecha hacia abajo si no está en el final
                if ((firstVisibleItemPosition + visibleItemCount) < totalItemCount) {
                    // Mostrar flecha abajo
                    binding.imDown.visibility = View.VISIBLE
                } else {
                    // Ocultar flecha abajo
                    binding.imDown.visibility = View.GONE
                }

                // Mostrar la flecha hacia arriba si no está en el inicio
                if (firstVisibleItemPosition > 0) {
                    // Mostrar flecha arriba
                    binding.imUp.visibility = View.VISIBLE
                } else {
                    // Ocultar flecha arriba
                    binding.imUp.visibility = View.GONE
                }
            }
        })
    }
}
