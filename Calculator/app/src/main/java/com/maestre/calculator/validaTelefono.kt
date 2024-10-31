package com.maestre.calculator

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.maestre.calculator.databinding.ActivityValidaTelefonoBinding

class validaTelefono : AppCompatActivity() {
    private lateinit var binding: ActivityValidaTelefonoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValidaTelefonoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnValidar.setOnClickListener() {
            validarTelefono(binding.tietPhone.text.toString())
        }
        binding.button21.setOnClickListener{
            val intent = Intent(this, ActividadNueva::class.java)
            startActivity(intent)
        }

    }
    fun validarTelefono(telefono: String){

        if(Patterns.PHONE.matcher(telefono).matches()){
            binding.tietPhone.setError(null)
        }else{
            binding.tietPhone.setError("El telefono no es valido")
        }
    }
}