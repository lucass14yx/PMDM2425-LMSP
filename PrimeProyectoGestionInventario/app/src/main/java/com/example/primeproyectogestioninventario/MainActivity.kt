package com.example.primeproyectogestioninventario

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.primeproyectogestioninventario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TablaNormal.OnDataExtractedListener, TablaCampo.OnDataExtractedListener {

    companion object {
        const val SPINNER_DATA = "SPINNER_DATA"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var spinnerArrayAdaptador: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializamos el adaptador con una lista vacía
        spinnerArrayAdaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, mutableListOf<String>())
        spinnerArrayAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = spinnerArrayAdaptador

        binding.checkBoxCampo.setOnCheckedChangeListener { _, _ ->
            replaceFragmentBasedOnCheckBox()
        }
    }

    private fun replaceFragmentBasedOnCheckBox() {
        // Reemplazar el fragmento según el estado del CheckBox
        if (binding.checkBoxCampo.isChecked) {
            val fragment = TablaCampo()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragment) // Reemplazar con TablaCampo
                .commit()
            // Pasar los datos a la actividad para que se actualice el spinner
            fragment.setOnDataExtractedListener(this)
        } else {
            val fragment = TablaNormal()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragment) // Reemplazar con TablaNormal
                .commit()
            // Pasar los datos a la actividad para que se actualice el spinner
            fragment.setOnDataExtractedListener(this)
        }

    }

    // Método que es llamado cuando los datos son extraídos del fragmento
    override fun onDataExtracted(herramientas: ArrayList<String>) {
        // Limpiar y agregar los nuevos elementos al adaptador
        spinnerArrayAdaptador.clear()
        spinnerArrayAdaptador.addAll(herramientas)
        spinnerArrayAdaptador.notifyDataSetChanged()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardar los datos actuales del adaptador
        val spinnerItems = ArrayList((0 until spinnerArrayAdaptador.count).map { spinnerArrayAdaptador.getItem(it).orEmpty() })
        outState.putStringArrayList(SPINNER_DATA, spinnerItems)
        // Guardar el índice seleccionado
        outState.putInt("SELECTED_ITEM_POSITION", binding.spinner.selectedItemPosition)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // Restaurar los datos del adaptador
        val restoredData = savedInstanceState.getStringArrayList(SPINNER_DATA).orEmpty()
        spinnerArrayAdaptador.clear()
        spinnerArrayAdaptador.addAll(restoredData)
        spinnerArrayAdaptador.notifyDataSetChanged()

        // Restaurar el índice seleccionado
        val selectedItemPosition = savedInstanceState.getInt("SELECTED_ITEM_POSITION", 0)
        binding.spinner.setSelection(selectedItemPosition)

    }


}
