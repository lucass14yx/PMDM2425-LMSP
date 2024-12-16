package com.examen.sqlitemvvm.com.maestre.sqlitemvvm.conexion

import com.examen.sqlitemvvm.com.maestre.sqlitemvvm.conexion.adapter.AbogadoAdapter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.maestre.sqlitemvvm.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import com.maestre.sqlitemvvm.R
import com.examen.sqlitemvvm.com.maestre.sqlitemvvm.conexion.viewmodel.AbogadoViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myAdapter: AbogadoAdapter
    val viewmodel: AbogadoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configurar barra de herramientas
        val toolbar: MaterialToolbar = binding.materialToolbar2
        setSupportActionBar(toolbar)

        // Configuramos el RecyclerView
        initRecyclerView(viewmodel)

        //si cambian los datos, actualizar rv
        viewmodel.data.observe(this) { data ->
            myAdapter.updateData(data)
        }
    }

    private fun initRecyclerView(viewmodel: AbogadoViewModel) {
        val manager = LinearLayoutManager(this)
        binding.rvAbogados.layoutManager = manager
        myAdapter = AbogadoAdapter(mutableListOf())
        binding.rvAbogados.adapter = myAdapter

        // Crear un DividerItemDecoration y agregarlo al RecyclerView
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.rvAbogados.addItemDecoration(decoration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_add -> {
                val intent = Intent(this, AbogadoActivity::class.java)
                intent.putExtra("mode","NEW")
                startActivity(intent)
                finish()
                true
            }
            R.id.menu_detalle -> {
                val selectedItem = myAdapter.getSelectedItem()
                if (selectedItem != null) {
                    val intent = Intent(this, AbogadoActivity::class.java)
                    intent.putExtra("mode","DETAIL")
                    intent.putExtra("abogado_data",selectedItem)
                    startActivity(intent)
                    finish()
                }
                true
            }
            R.id.menu_edicion -> {
                val selectedItem = myAdapter.getSelectedItem()
                if (selectedItem != null) {
                    val intent = Intent(this, AbogadoActivity::class.java)
                    intent.putExtra("mode","EDIT")
                    intent.putExtra("abogado_data",selectedItem)
                    startActivity(intent)
                    finish()
                }
                true
            }
            R.id.menu_eliminar -> {
                val selectedItem = myAdapter.getSelectedItem()
                if (selectedItem != null) {
                    viewmodel.delete(selectedItem)
                    myAdapter.notifyItemRemoved(myAdapter.getSelectedPosition())
                    myAdapter.notifyDataSetChanged()
                    Toast.makeText(this,"Se eliminó el dato", Toast.LENGTH_SHORT).show()
                }
                true
            }
            else -> false
        }
    }
}