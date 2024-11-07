package com.maestre.toolbarexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maestre.toolbarexample.databinding.FragmentEjemploFragmentoEstaticoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EjemploFragmentoEstatico.newInstance] factory method to
 * create an instance of this fragment.
 */
class EjemploFragmentoEstatico : Fragment() {
    private lateinit var binding: FragmentEjemploFragmentoEstaticoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEjemploFragmentoEstaticoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}