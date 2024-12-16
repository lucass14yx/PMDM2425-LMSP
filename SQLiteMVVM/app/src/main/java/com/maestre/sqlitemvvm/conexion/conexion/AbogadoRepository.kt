package com.examen.sqlitemvvm.com.maestre.sqlitemvvm.conexion.conexion

import androidx.lifecycle.LiveData
import com.examen.sqlitemvvm.com.maestre.sqlitemvvm.conexion.model.Abogado

class AbogadoRepository(private val abogadoDAO: AbogadoDAO) {
    fun getAllAbogados(): LiveData<List<Abogado>> {
        return abogadoDAO.getAllAbogados()
    }

    suspend fun insert(abogado: Abogado) {
        abogadoDAO.insert(abogado)
    }

    suspend fun update(abogado: Abogado) {
        abogadoDAO.update(abogado)
    }

    suspend fun delete(abogado: Abogado) {
        abogadoDAO.delete(abogado)
    }

    fun getAbogadoById(id: Int): LiveData<Abogado> {
        return abogadoDAO.getAbogadoById(id)
    }
}
