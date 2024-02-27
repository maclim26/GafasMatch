package com.gafasmatch.visualstyle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gafasmatch.visualstyle.data.FavItem
import com.gafasmatch.visualstyle.databinding.ItemFavBinding

class FavItemAdapter (
    private val favItemList: List<FavItem>,
    private val onDeleteClickListener: (Int) -> Unit
) : RecyclerView.Adapter<FavItemAdapter.FavItemViewHolder>() {

    inner class FavItemViewHolder(private val binding: ItemFavBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favItem: FavItem) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFavBinding.inflate(inflater, parent, false)
        return FavItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavItemViewHolder, position: Int) {
        val favItem = favItemList[position]
        holder.bind(favItem)
    }

    override fun getItemCount(): Int {
        return favItemList.size
    }
}