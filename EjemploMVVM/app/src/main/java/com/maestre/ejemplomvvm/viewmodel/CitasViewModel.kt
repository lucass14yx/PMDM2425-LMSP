package com.maestre.ejemplomvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.maestre.ejemplomvvm.model.CitaModel
import com.maestre.ejemplomvvm.model.ProveedorCitas

class CitasViewModel : ViewModel(){
    var cita: CitaModel
    init {
        cita = ProveedorCitas.getCitaRandom()
    }
}