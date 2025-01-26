package com.example.sql_lite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import modelo.Persona
import conexion.PersonaConexionHelper
import com.example.sql_lite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.edDNI.requestFocus()
    }

    fun addPersona(view: View) {
        var edDNI = binding.edDNI
        var edNombre = binding.edNombre
        var edEdad = binding.edEdad

        if (edDNI.text.toString().trim().isEmpty() || edNombre.text.toString().trim().isEmpty()
            || edEdad.text.toString().trim().isEmpty()){
            Toast.makeText(this, "Campos en blanco", Toast.LENGTH_SHORT).show()
        }
        else {
            var pers: Persona = Persona(
                edDNI.getText().toString(),
                edNombre.getText().toString(),
                edEdad.getText().toString().toInt()
            )
            var codigo= PersonaConexionHelper.addPersona(this, pers)
            edDNI.setText("")
            edNombre.setText("")
            edEdad.setText("")
            edDNI.requestFocus()
            if(codigo==-1L) {
                Toast.makeText(this, "Ya existe ese DNI. Persona NO insertada", Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                Toast.makeText(this, "Persona insertada", Toast.LENGTH_SHORT).show()
                listarPersonas(view)
            }
        }
    }

    fun delPersona(view: View) {
        var edDNI = binding.edDNI
        var edNombre = binding.edNombre
        var edEdad = binding.edEdad
        var cant = PersonaConexionHelper.delPersona(this, edDNI.text.toString())
        edDNI.setText("")
        edNombre.setText("")
        edEdad.setText("")
        if (cant == 1) {
            Toast.makeText(this, "Se borró la persona con ese DNI", Toast.LENGTH_SHORT).show()
            listarPersonas(view)
        }
        else
            Toast.makeText(this, "No existe una persona con ese DNI", Toast.LENGTH_SHORT).show()

    }

    fun modPersona(view: View) {
        var edDNI = binding.edDNI
        var edNombre = binding.edNombre
        var edEdad = binding.edEdad
        if (edDNI.text.toString().trim().isEmpty()|| edNombre.text.toString().trim().isEmpty()
            || edEdad.text.toString().trim().isEmpty()){
            Toast.makeText(this, "Campos en blanco", Toast.LENGTH_SHORT).show()
        }
        else {
            var pers: Persona = Persona(
                edDNI.getText().toString(),
                edNombre.getText().toString(),
                edEdad.getText().toString().toInt()
            )
            var cant = PersonaConexionHelper.modPersona(this, edDNI.text.toString(), pers)
            if (cant == 1)
                Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe una persona con ese DNI", Toast.LENGTH_SHORT).show()
        }
        listarPersonas(view)
    }

    fun buscarPersona(view: View) {
        var edDNI = binding.edDNI
        var edNombre = binding.edNombre
        var edEdad = binding.edEdad
        var p:Persona? = null
        p = PersonaConexionHelper.buscarPersona(this, edDNI.text.toString())
        if (p!=null) {
            edNombre.setText(p.nombre)
            edEdad.setText(p.edad.toString())
        } else {
            Toast.makeText(this, "No existe una persona con ese DNI", Toast.LENGTH_SHORT).show()
        }

    }


    fun listarPersonas(view: View) {
        var txtListdo = binding.txtListado
        txtListdo.setText("")
        //
        var listado:ArrayList<Persona> = PersonaConexionHelper.obtenerPersonas(this)
        if (listado.isEmpty()) {
            Toast.makeText(this, "No existen datos en la tabla", Toast.LENGTH_SHORT).show()
        }
        else {
            for(p in listado){
                var cadena = p.dni + ", " + p.nombre + ", " + p.edad.toString() + "\r\n"
                txtListdo.append(cadena)
            }
        }
    }


}