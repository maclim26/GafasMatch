package com.gafasmatch.visualstyle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gafasmatch.visualstyle.adapter.GafasAdapter
import com.gafasmatch.visualstyle.data.DataSource
import com.gafasmatch.visualstyle.data.Gafa
import com.gafasmatch.visualstyle.databinding.FragmentItenListBinding

class ItenListFragment : Fragment() ,GafasAdapter.OnFavoriteClickListener {

    private var _binding : FragmentItenListBinding? = null
    val binding
        get() = _binding!!
    private val gafasList: List<Gafa> = DataSource.getGafaList()
    private lateinit var adapter: GafasAdapter

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
        adapter = GafasAdapter(gafaList, this)
        binding.rvGafas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvGafas.adapter = adapter
    }
    override fun onFavoriteClicked(position: Int) {
         val selectedGafa = gafasList[position]
         selectedGafa.isFavorite = true
         adapter.notifyItemChanged(position)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}