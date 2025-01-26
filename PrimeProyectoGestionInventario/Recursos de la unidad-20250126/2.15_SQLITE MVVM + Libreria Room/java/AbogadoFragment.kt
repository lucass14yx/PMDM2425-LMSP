package com.examen.sqlitemvvm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.examen.sqlitemvvm.databinding.FragmentAbogadoBinding
import model.Abogado
import viewmodel.AbogadoViewModel

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_MODE = "mode"
private const val ARG_DATA = "abogado_data"

class AbogadoFragment : Fragment() {
    private var mode: String? = null
    private var data: Abogado? = null
    lateinit var binding: FragmentAbogadoBinding
    private val sharedViewModel: AbogadoViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mode = it.getString(ARG_MODE)
            data = it.getSerializable(ARG_DATA, Abogado::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAbogadoBinding.inflate(inflater, container, false)

        //poner datos
        binding.idAbogado.setText(data?.idAbogado.toString())
        binding.eNombre.setText(data?.nombre)
        binding.eTelefono.setText(data?.telefono)
        binding.eEspecialidad.setText(data?.especialidad)
        binding.eBiografia.setText(data?.biografia)

        //configurar la pantalla segun el modo
        initByMode()
        return binding.root
    }

    private fun initByMode() {
        when(mode){
            "DETAIL" ->{
                binding.title.setText(getString(R.string.detail_title))
                binding.eNombre.isEnabled = false
                binding.eTelefono.isEnabled = false
                binding.eEspecialidad.isEnabled = false
                binding.eBiografia.isEnabled = false
                binding.btAceptar.visibility = View.GONE
            }
            "NEW" -> {
                binding.title.setText(getString(R.string.add_title))
                binding.eNombre.isEnabled = true
                binding.eTelefono.isEnabled = true
                binding.eEspecialidad.isEnabled = true
                binding.eBiografia.isEnabled = true
                binding.btAceptar.visibility = View.VISIBLE
            }
            "EDIT" -> {
                binding.title.setText(getString(R.string.edit_title))
                binding.eNombre.isEnabled = true
                binding.eTelefono.isEnabled = true
                binding.eEspecialidad.isEnabled = true
                binding.eBiografia.isEnabled = true
                binding.btAceptar.visibility = View.VISIBLE
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btVolver.setOnClickListener(){
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        binding.btAceptar.setOnClickListener(){
            var etNombre = binding.eNombre
            var etTelefono = binding.eTelefono
            var etEspecialidad = binding.eEspecialidad
            var etBiografia = binding.eBiografia

            if (etNombre.text.toString().trim().isEmpty()
                || etTelefono.text.toString().trim().isEmpty()
                || etEspecialidad.text.toString().trim().isEmpty()
                || etBiografia.text.toString().trim().isEmpty()){
                Toast.makeText(requireContext(), "Campos en blanco", Toast.LENGTH_SHORT).show()
            }
            else {
                if (mode == "NEW") {
                    val abogado = Abogado(0,
                        binding.eNombre.text.toString(),
                        binding.eTelefono.text.toString(),
                        binding.eEspecialidad.text.toString(),
                        binding.eBiografia.text.toString()
                    )
                    sharedViewModel.insert(abogado)
                    Toast.makeText(requireContext(),"Se añadieron los datos",Toast.LENGTH_SHORT).show()
                }
                else if (mode == "EDIT") {
                    val abogado = Abogado(binding.idAbogado.text.toString().toInt(),
                        binding.eNombre.text.toString(),
                        binding.eTelefono.text.toString(),
                        binding.eEspecialidad.text.toString(),
                        binding.eBiografia.text.toString()
                    )
                    sharedViewModel.update(abogado)
                    Toast.makeText(requireContext(),"Se modificaron los datos",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}