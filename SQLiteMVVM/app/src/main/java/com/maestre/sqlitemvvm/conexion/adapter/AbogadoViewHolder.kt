package com.examen.sqlitemvvm.com.maestre.sqlitemvvm.conexion.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maestre.sqlitemvvm.databinding.ItemListaBinding

class AbogadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemListaBinding.bind(itemView)
    val tvNombre: TextView = binding.tvNombre

    var isBackgroundColorChanged = false
}