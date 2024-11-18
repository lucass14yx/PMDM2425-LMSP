package com.example.primeproyectogestioninventario

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.primeproyectogestioninventario.databinding.FragmentTablaNormalBinding

class TablaNormal : Fragment() {
    private lateinit var binding: FragmentTablaNormalBinding
    private var listener: OnDataExtractedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDataExtractedListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar OnDataExtractedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTablaNormalBinding.inflate(inflater, container, false)

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
        @JvmStatic
        fun newInstance() = TablaNormal()
    }
}