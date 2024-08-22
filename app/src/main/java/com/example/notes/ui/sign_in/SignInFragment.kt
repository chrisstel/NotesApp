package com.example.notes.ui.sign_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private var binding: FragmentSignInBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentSignInBinding.inflate(layoutInflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signIn()
        createAccount()
    }

    private fun signIn() = views {
        signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
        }
    }

    private fun createAccount() = views {
        dontHaveAccountText.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_createAccountFragment)
        }
    }

    private fun <T> views(block: FragmentSignInBinding.() -> T): T? = binding?.block()
}