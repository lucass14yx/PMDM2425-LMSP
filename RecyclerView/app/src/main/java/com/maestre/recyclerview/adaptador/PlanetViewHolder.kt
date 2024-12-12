package com.maestre.recyclerview.adaptador

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maestre.recyclerview.databinding.ItemPlanetaBinding

class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemPlanetaBinding.bind(itemView)

    val nameTextView: TextView = binding.planetName
    val sizeTextView: TextView = binding.planetSize
    val distanceTextView: TextView = binding.planetDistance
    val planetaImageView: ImageView = binding.ivPlaneta
}