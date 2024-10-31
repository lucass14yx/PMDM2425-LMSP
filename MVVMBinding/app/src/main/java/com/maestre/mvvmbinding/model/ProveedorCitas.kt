package com.maestre.mvvmbinding.model

object ProveedorCitas {
    fun getCitaRandom(): CitaModel {
        val position = (0 until citas.size).random()
        return citas[position]
    }
    private val citas = listOf(
        CitaModel(
            cita = "El respeto al derecho ajeno es la paz",
            autor = "Benito Juargerro"

        ),
        CitaModel(
            cita = "No hay caminos para la paz; la paz es el camino",
            autor = "Mahatma Gandhi"
        ),
        CitaModel(
            cita = "Sólo sé que no sé nada",
            autor = "Sócrates"
        ),
        CitaModel(
            cita = "Hace frío en Teruel",
            autor = "Fulanito"
        )

    )
}