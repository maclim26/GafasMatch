package com.gafasmatch.visualstyle

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gafasmatch.visualstyle.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()


    private var _binding: FragmentLoginBinding? = null
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
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        // Manejar clics en el botón
        binding.btnGoToCredit.setOnClickListener {
            // Obtener el nombre de usuario del EditText
            val username = binding.editTextUsuario.text.toString()

            // Guardar el nombre de usuario en el ViewModel compartido
            SharedViewModel.username = username

            // Navegar al MenuFragment
            findNavController().navigate(R.id.action_loginFragment_to_menuFragment)

        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}