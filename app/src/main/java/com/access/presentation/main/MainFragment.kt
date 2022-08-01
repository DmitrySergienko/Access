package com.access.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.access.R
import com.access.databinding.FragmentMainBinding


class MainFragment : Fragment() {


    private var _binding: FragmentMainBinding? = null
    val binding: FragmentMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1).navigate(R.id.action_mainFragment2_to_logInFragment)
            }
        }
        return binding.root
    }

    companion object {

        fun newInstance() = MainFragment()
    }
}