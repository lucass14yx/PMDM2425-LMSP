package adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewejemplobasico.databinding.ItemCantanteBinding


class CantanteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemCantanteBinding.bind(itemView)

    val textView: TextView = binding.txCantante
    var isBackgroundColorChanged = false // Flag to track color state
}