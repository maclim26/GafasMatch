package com.gafasmatch.visualstyle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gafasmatch.visualstyle.R
import com.gafasmatch.visualstyle.data.Gafa
import com.gafasmatch.visualstyle.databinding.GafaItemBinding

class GafasAdapter(private val gafasList: List<Gafa>,
                   private val favoriteClickListener: OnFavoriteClickListener,
                   private val onItemClickListener: OnItemClickListener
): RecyclerView.Adapter<GafaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GafaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GafaViewHolder(layoutInflater.inflate(R.layout.gafa_item, parent, false))
    }

    override fun getItemCount(): Int = gafasList.size


    override fun onBindViewHolder(
        holder: GafaViewHolder,
        position: Int
    ) {
        val gafa = gafasList[position]
        holder.bind(gafa)
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(gafa)
        }
    }

    interface OnFavoriteClickListener {
        fun onFavoriteClicked(position: Int)
    }
    interface OnItemClickListener {
        fun onItemClick(gafa: Gafa)
    }
}