package com.examen.sqlitemvvm.com.maestre.sqlitemvvm.conexion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maestre.sqlitemvvm.R
import com.maestre.sqlitemvvm.conexion.model.Abogado

class AbogadoActivity : AppCompatActivity() {
    lateinit var mode:String
    var abogado: Abogado? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abogado)

        //recuperar datos
        val intent = intent
        mode = intent.getStringExtra("mode") ?: "DETAIL"
        abogado = intent.getSerializableExtra("abogado_data", Abogado::class.java)

        //pasar datos al fragmento
        val bundle = Bundle()
        bundle.putString("mode", mode)
        bundle.putSerializable("abogado_data", abogado)

        val myFragment = AbogadoFragment()
        myFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, myFragment)
            .commit()
    }
}