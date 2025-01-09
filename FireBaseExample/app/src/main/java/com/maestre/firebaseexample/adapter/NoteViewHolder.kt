package com.maestre.firebaseexample.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maestre.firebaseexample.databinding.ItemNoteBinding

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemNoteBinding.bind(itemView)
    val titulo: TextView = binding.title
    val contenido: TextView = binding.content
}
