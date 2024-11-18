package com.example.primeproyectogestioninventario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import com.example.primeproyectogestioninventario.databinding.FragmentTablaCampoBinding
import com.example.primeproyectogestioninventario.databinding.FragmentTablaNormalBinding

// TODO: Rename parameter arguments, choose names that match

/**
 * A simple [Fragment] subclass.
 * Use the [TablaCampo.newInstance] factory method to
 * create an instance of this fragment.
 */
class TablaCampo : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding: FragmentTablaCampoBinding
    private var listener: OnDataExtractedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTablaCampoBinding.inflate(inflater, container, false)

        // Extraer datos de la tabla
        val herramientas = ArrayList<String>()
        val tabla = binding.tableLayout

        for (i in 0 until tabla.childCount) {
            val celda = tabla.getChildAt(i)
            if (celda is TableRow) {
                val texto = celda.getChildAt(0)
                if (texto is TextView) {
                    herramientas.add(texto.text.toString())
                }
            }
        }
        // Llamar a onDataExtracted en la actividad
        listener?.onDataExtracted(herramientas)
        return binding.root
    }

    // Interfaz para enviar datos a la actividad
    interface OnDataExtractedListener {
        fun onDataExtracted(herramientas: ArrayList<String>)
    }

    fun setOnDataExtractedListener(listener: OnDataExtractedListener) {
        this.listener = listener
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment TablaCampo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = TablaCampo()
    }
}