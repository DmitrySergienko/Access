package com.access.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.access.R
import com.access.data.api.model.Login
import com.access.databinding.FragmentLogInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInFragment : Fragment() {


    private val viewModel: LoginViewModel by viewModels()

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



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            val myPost = Login("3", "3")
            viewModel.pushLogin(myPost)
            viewModel.loginLiveData.observe(requireActivity(), Observer { response ->
                if (response.isSuccessful) {
                    Log.d("VVV", response.body().toString())
                    Log.d("VVV", response.code().toString())
                    Log.d("VVV", response.message().toString())

                    Toast.makeText(requireContext(), response.body().toString(), Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Log.d("VVV", response.code().toString())
                }
            })
        }

    }
    companion object {

        @JvmStatic
        fun newInstance() = LogInFragment()
    }
}