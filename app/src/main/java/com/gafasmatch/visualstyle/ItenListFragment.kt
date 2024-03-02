package com.gafasmatch.visualstyle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gafasmatch.visualstyle.adapter.GafasAdapter
import com.gafasmatch.visualstyle.data.DataSource
import com.gafasmatch.visualstyle.data.FavItem
import com.gafasmatch.visualstyle.data.Gafa
import com.gafasmatch.visualstyle.databinding.FragmentItenListBinding

class ItenListFragment : Fragment() ,GafasAdapter.OnFavoriteClickListener,GafasAdapter.OnItemClickListener {

    private var _binding : FragmentItenListBinding? = null
    val binding
        get() = _binding!!
    private val gafasList: List<Gafa> = DataSource.getGafaList()
    private lateinit var adapter: GafasAdapter
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentItenListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView(gafasList)

    }
    private fun initRecyclerView(gafaList: List<Gafa>) {
        adapter = GafasAdapter(gafaList, this,this)
        binding.rvGafas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvGafas.adapter = adapter
    }
    override fun onFavoriteClicked(position: Int) {
         val selectedGafa = gafasList[position]
         selectedGafa.isFavorite = !selectedGafa.isFavorite
         adapter.notifyItemChanged(position)
        // Agregar el elemento como favorito
        if (selectedGafa.isFavorite) {
            sharedViewModel.addFavItem(FavItem(selectedGafa.id, selectedGafa.foto,selectedGafa.nombre, selectedGafa.descripcion))
            // Navegar al fragmento de lista de favoritos
            findNavController().navigate(R.id.action_itenListFragment_to_favItemListFragment)
        } else {
            //eliminar el elemento de la lista de favoritos cuando ya no es favorito

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(gafa: Gafa) {
        val action = ItenListFragmentDirections.actionItenListFragmentToDetailItemFragment(gafa)
        findNavController().navigate(action)
    }

}