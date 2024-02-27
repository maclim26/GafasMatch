package com.gafasmatch.visualstyle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gafasmatch.visualstyle.adapter.PrivateCommentAdapter
import com.gafasmatch.visualstyle.data.PrivateComment
import com.gafasmatch.visualstyle.databinding.FragmentDetailFavItemBinding

class DetailFavItemFragment : Fragment() {
    private var _binding: FragmentDetailFavItemBinding? = null
    private val binding get() = _binding!!

    private lateinit var privateCommentAdapter: PrivateCommentAdapter
    private val privateCommentList: MutableList<PrivateComment> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailFavItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        setupAddCommentButton()
    }

    private fun initRecyclerView() {
        privateCommentAdapter = PrivateCommentAdapter(privateCommentList)

        binding.rvDetailFav.apply {
            adapter = privateCommentAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupAddCommentButton() {
        binding.fabAddComment.setOnClickListener {
            // lógica para agregar un nuevo comentario privado
            // mostrar un cuadro de diálogo o navegar a una pantalla de agregar comentario
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}