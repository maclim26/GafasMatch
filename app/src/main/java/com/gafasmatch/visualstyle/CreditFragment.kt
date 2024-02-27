package com.gafasmatch.visualstyle

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gafasmatch.visualstyle.databinding.FragmentCreditBinding


class CreditFragment : Fragment() {
    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)

        // Obtener el nombre de usuario del ViewModel compartido
        val username = SharedViewModel.username

        // Configurar el texto en TextViews
        binding.textViewVersion.text= "$username, estás usando la versión 1 de..."

        // Configurar el botón de contacto
        binding.btnContact.setOnClickListener {
            enviarCorreoConsulta()
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun enviarCorreoConsulta() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("cmaclim365@g.educaand.es"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app GafasMatch")
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }
}