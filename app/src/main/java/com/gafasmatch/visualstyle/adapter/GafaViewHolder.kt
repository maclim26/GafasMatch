package com.gafasmatch.visualstyle.adapter

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gafasmatch.visualstyle.R
import com.gafasmatch.visualstyle.data.Gafa
import com.gafasmatch.visualstyle.databinding.GafaItemBinding

class GafaViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = GafaItemBinding.bind(view)

    fun bind(gafaModel: Gafa){
        binding.tvName.text = gafaModel.nombre
        binding.tvDescription.text = gafaModel.descripcion

        Glide.with(binding.ivPhoto.context).load(gafaModel.foto).into(binding.ivPhoto)
        binding.ivPhoto.setOnClickListener{
            Toast.makeText(
                binding.ivPhoto.context,
                gafaModel.nombre,
                Toast.LENGTH_SHORT
            ).show()
        }
        itemView.setOnClickListener{
            Toast.makeText(
                binding.ivPhoto.context,
                gafaModel.descripcion,
                Toast.LENGTH_SHORT
            ).show()
        }

        // Obtén la referencia a la imagen de favorito
        val ivFavorite: ImageView = itemView.findViewById(R.id.ivFavorite)

        binding.ivFavorite.setOnClickListener {
            // Verifica si el ítem está en favoritos
            val isFavorite = gafaModel.isFavorite

            if (!isFavorite) {
                // Si no está en favoritos, marca como favorito y cambia la imagen a ic_favorite
                gafaModel.isFavorite = true
                ivFavorite.setImageResource(R.drawable.ic_favorite)
                Toast.makeText(
                    itemView.context,
                    "Agregado a favoritos: ${gafaModel.nombre}",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Si está en favoritos, quita de favoritos y cambia la imagen a ic_favorite_border
                gafaModel.isFavorite = false
                ivFavorite.setImageResource(R.drawable.ic_favorite_border)
                Toast.makeText(
                    itemView.context,
                    "Eliminado de favoritos: ${gafaModel.nombre}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}