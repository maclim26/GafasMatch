package com.gafasmatch.visualstyle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.gafasmatch.visualstyle.databinding.FragmentDetailItemBinding


class DetailItemFragment : Fragment() {


    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!
    // Obtener los argumentos pasados al Fragmento y asignarlos a la variable
    private val args: DetailItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obtener los datos del argumento y asignarlos a las vistas
        val gafa = args.selectedGafa
        binding.textViewTitle.text = gafa.nombre
        binding.textViewDescription.text = gafa.descripcion
        val opticaText = "Óptica: ${gafa.optica}"
        binding.textViewNombreOptica.text = opticaText
        Glide.with(this)
            .load(gafa.foto)
            .into(binding.imageView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}