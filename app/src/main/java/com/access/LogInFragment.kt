package com.access

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.access.databinding.FragmentLogInBinding


class LogInFragment : Fragment() {

    private var _binding: FragmentLogInBinding? = null
    val binding: FragmentLogInBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLogInBinding.inflate(inflater, container, false)

        binding.showHideBtn.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1).navigate(R.id.navigate_to_signup_fragment)
            }
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            LogInFragment()
    }
}