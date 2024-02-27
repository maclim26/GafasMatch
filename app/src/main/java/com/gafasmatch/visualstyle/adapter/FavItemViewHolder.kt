package com.gafasmatch.visualstyle.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gafasmatch.visualstyle.data.FavItem
import com.gafasmatch.visualstyle.databinding.ItemFavBinding

class FavItemViewHolder (private val binding: ItemFavBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(favItem: FavItem, onDeleteClickListener: (Int) -> Unit) {
        binding.textViewTitle.text = favItem.title
        binding.textViewDescription.text = favItem.description

        binding.ivDelFav.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onDeleteClickListener(position)
            }
        }
    }
}