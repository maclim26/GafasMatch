package com.gafasmatch.visualstyle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gafasmatch.visualstyle.adapter.FavItemAdapter
import com.gafasmatch.visualstyle.data.DataSource
import com.gafasmatch.visualstyle.data.FavItem
import com.gafasmatch.visualstyle.data.Gafa
import com.gafasmatch.visualstyle.databinding.FragmentFavItemListBinding

class FavItemListFragment : Fragment() {
    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!

    private lateinit var favItemAdapter: FavItemAdapter
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val favItemList: MutableList<FavItem> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inicializa el RecyclerView si aún no ha sido inicializado
        if (!::favItemAdapter.isInitialized) {
            initRecyclerView()
        }

        val sharedViewModel: SharedViewModel by activityViewModels()

        // Observa los cambios en los elementos favoritos
        sharedViewModel.favItems.observe(viewLifecycleOwner, Observer { favItems ->

            if (::favItemAdapter.isInitialized) {
                updateFavItems(favItems)
            }
        })

    }

    private fun initRecyclerView() {
        favItemAdapter = FavItemAdapter(favItemList) { position ->
            // Eliminar un elemento de la lista de favoritos
            val deletedItem = favItemList[position]
            favItemList.removeAt(position)
            favItemAdapter.notifyItemRemoved(position)
            // Notificar al ViewModel sobre la eliminación del elemento
            sharedViewModel.removeFavItem(deletedItem)
        }

        binding.rvGafasFav.layoutManager = LinearLayoutManager(requireContext())
        binding.rvGafasFav.adapter = favItemAdapter
    }
    fun updateFavItems(favItems: List<FavItem>) {
        favItemList.clear()
        favItemList.addAll(favItems)
        favItemAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}