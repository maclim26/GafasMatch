package com.gafasmatch.visualstyle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gafasmatch.visualstyle.adapter.FavItemAdapter
import com.gafasmatch.visualstyle.data.FavItem
import com.gafasmatch.visualstyle.databinding.FragmentFavItemListBinding

class FavItemListFragment : Fragment() {
    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!

    private lateinit var favItemAdapter: FavItemAdapter
    private val favItemList: MutableList<FavItem> = mutableListOf() // Aquí debes obtener la lista de elementos favoritos del usuario

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        favItemAdapter = FavItemAdapter(favItemList) { position ->
            //eliminar un elemento de la lista de favoritos
            val deletedItem = favItemList.removeAt(position)
            favItemAdapter.notifyItemRemoved(position)
        }

        binding.rvGafasFav.apply {
            adapter = favItemAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}