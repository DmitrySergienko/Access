package com.access.presentation.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.access.R
import com.access.databinding.FragmentSignupBinding
import com.access.domain.entity.ReguistrationRequest
import com.access.presentation.login.LogInFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class SignupFragment : Fragment() {

    private val viewModel: RegistrationViewModel by viewModels()

    private var _binding: FragmentSignupBinding? = null
    val binding: FragmentSignupBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignupBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1).navigate(R.id.action_navigate_to_log_in_fragment)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.enterButton.setOnClickListener {

            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val firstName = binding.firstNameEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()

            if (email.isBlank() || password.isBlank() || lastName.isBlank()
                || firstName.isBlank() || phone.isBlank()
            ) {
                Toast.makeText(requireContext(), "PLEASE COMPLETE ALL FIELDS", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val myPost = ReguistrationRequest(email, password, lastName, phone, firstName)
                viewModel.pushRegistration(myPost)

                lifecycleScope.launchWhenStarted {
                    viewModel.regSharedFlow.collectLatest {
                        if (it.isSuccessful) {

                            view.let { it1 ->
                                Navigation.findNavController(it1)
                                    .navigate(R.id.action_navigate_to_log_in_fragment)
                            }

                        } else {
                            Log.d("VVV", it.body().toString())
                        }
                    }
                }
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = LogInFragment()

    }
}
