package com.maestre.mvvmbinding.viewmodel

import androidx.lifecycle.ViewModel
import com.maestre.mvvmbinding.model.CitaModel
import com.maestre.mvvmbinding.model.ProveedorCitas

class CitasViewModel : ViewModel(){
    var cita: CitaModel
    init {
        cita = ProveedorCitas.getCitaRandom()
    }
}