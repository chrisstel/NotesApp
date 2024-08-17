package com.example.notes.ui.create_account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentCreateAccountBinding
import com.example.notes.domain.data.ValidationResult
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateAccountFragment : Fragment() {

    private val viewModel: CreateAccountViewModel by viewModel()
    private var binding: FragmentCreateAccountBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCreateAccountBinding.inflate(layoutInflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        views {
            alreadyHaveAccountText.setOnClickListener { signIn() }

            createAccountButton.setOnClickListener {
                signUp()
                handleSignUpResult()
            }
        }
    }

    private fun signIn() {
        findNavController().navigate(R.id.action_createAccountFragment_to_signInFragment)
    }

    private fun signUp() {
        views {
            val nickname = nickname.text.toString()
            val emailAddress = emailAddress.text.toString()
            val password = password.text.toString()

            viewModel.signUp(
                nickname = nickname,
                emailAddress = emailAddress,
                password = password
            )
        }
    }

    private fun handleSignUpResult() {
        onFail()
        onSuccess()
    }

    private fun onFail() {
        viewModel.validationState.observe(viewLifecycleOwner) { registration ->
            views {
                nickname.error = registration.nicknameError
                emailAddress.error = registration.emailAddressError
                password.error = registration.passwordError
            }
        }
    }

    private fun onSuccess() {
        viewModel.registrationResult.onEach { result ->
            when {
                result is ValidationResult.Success -> {
                    findNavController().navigate(R.id.action_createAccountFragment_to_mainFragment)
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun <T> views(block: FragmentCreateAccountBinding.() -> T): T? = binding?.block()
}