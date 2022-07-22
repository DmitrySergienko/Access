package com.access.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.access.R
import com.access.data.api.model.LoginRequest
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

            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            val myPost = LoginRequest(email, password)
            viewModel.pushLogin(myPost)

            viewModel.loginLiveData.observe(requireActivity(), Observer { response ->
                if (response.isSuccessful && response.body()?.pLOGIN_FLAG == "Y") {
                    view?.let { it1 ->
                        Navigation.findNavController(it1).navigate(R.id.action_logInFragment_to_mainFragment2)
                    }
                } else {
                    Log.d("VVV", response.body().toString())
                }
            })
        }

    }
    companion object {

        @JvmStatic
        fun newInstance() = LogInFragment()
    }
}