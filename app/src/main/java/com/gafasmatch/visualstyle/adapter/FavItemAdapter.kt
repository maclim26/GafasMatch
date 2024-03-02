package com.gafasmatch.visualstyle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gafasmatch.visualstyle.data.FavItem
import com.gafasmatch.visualstyle.databinding.ItemFavBinding

class FavItemAdapter (
    private var favItemList: List<FavItem>,
    private val onDeleteClickListener: (Int) -> Unit
) : RecyclerView.Adapter<FavItemAdapter.FavItemViewHolder>() {

    inner class FavItemViewHolder(private val binding: ItemFavBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favItem: FavItem) {
            binding.tvNameFav.text = favItem.title
            binding.tvDescriptionFav.text = favItem.description
            Glide.with(binding.ivPhotoFav.context).load(favItem.foto).into(binding.ivPhotoFav)
            binding.ivPhotoFav.setOnClickListener{
                Toast.makeText(
                    binding.ivPhotoFav.context,
                    favItem.title,
                    Toast.LENGTH_SHORT
                ).show()
            }
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
    fun submitList(newList: List<FavItem>) {
        favItemList = newList
        notifyDataSetChanged()
    }
}
