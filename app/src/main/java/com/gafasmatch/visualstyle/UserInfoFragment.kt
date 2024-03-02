package com.gafasmatch.visualstyle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.gafasmatch.visualstyle.databinding.FragmentUserInfoBinding


class UserInfoFragment : Fragment() {
    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.username.observe(viewLifecycleOwner) { username ->
            // Establecer el nombre de usuario en la vista correspondiente
            binding.tvusername.text = username
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}