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
        // Configurar el BottomNavigationView
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_discover -> {
                    // Navegar al fragmento ItemListFragment
                    findNavController().navigate(R.id.action_menuFragment_to_itenListFragment)
                    true
                }
                R.id.menu_favorites -> {
                    // Navegar al fragmento FavItemListFragment
                    findNavController().navigate(R.id.action_menuFragment_to_favItemListFragment)
                    true
                }
                R.id.menu_personal -> {
                    // Navegar al fragmento UserInfoFragment
                    findNavController().navigate(R.id.action_menuFragment_to_userInfoFragment)
                    true
                }
                else -> false
            }
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