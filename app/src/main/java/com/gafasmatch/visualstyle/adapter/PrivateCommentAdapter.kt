package com.gafasmatch.visualstyle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gafasmatch.visualstyle.data.PrivateComment
import com.gafasmatch.visualstyle.databinding.ItemPrivateCommentBinding

class PrivateCommentAdapter(private val privateCommentList: List<PrivateComment>) :
    RecyclerView.Adapter<PrivateCommentAdapter.PrivateCommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrivateCommentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPrivateCommentBinding.inflate(inflater, parent, false)
        return PrivateCommentViewHolder(binding)
    }

    override fun getItemCount(): Int = privateCommentList.size

    override fun onBindViewHolder(holder: PrivateCommentViewHolder, position: Int) {
        val privateComment = privateCommentList[position]
        holder.bind(privateComment)
    }

    inner class PrivateCommentViewHolder(private val binding: ItemPrivateCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(privateComment: PrivateComment) {
            binding.textViewComment.text = privateComment.comment

        }
    }
}