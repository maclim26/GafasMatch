package com.gafasmatch.visualstyle

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gafasmatch.visualstyle.databinding.FragmentLoginBinding
import com.gafasmatch.visualstyle.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
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
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        // Configurar clics de botón
        binding.btnCredits.setOnClickListener {
            navigateToCreditsFragment()
        }

        binding.btnSalir.setOnClickListener {
            navigateToLoginFragment()
        }
        return binding.root
    }
    private fun navigateToCreditsFragment() {
        findNavController().navigate(R.id.action_menuFragment_to_creditFragment)
    }

    private fun navigateToLoginFragment() {
        findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
    }


}