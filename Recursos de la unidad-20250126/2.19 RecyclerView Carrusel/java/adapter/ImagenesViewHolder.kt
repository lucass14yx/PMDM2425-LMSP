package adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ejemplo.recyclerviewimages.databinding.ImagenItemBinding


class ImagenesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ImagenItemBinding.bind(itemView)

    val imagenView: ImageView = binding.idImagenView
}