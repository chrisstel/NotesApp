package com.example.notes.ui.create_account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentCreateAccountBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateAccountFragment : Fragment() {

    private val viewModel: CreateAccountViewModel by viewModel()
    private var binding: FragmentCreateAccountBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentCreateAccountBinding.inflate(layoutInflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        views {
            alreadyHaveText.setOnClickListener {
                signIn()
            }

            getStartedButton.setOnClickListener {
                ///
            }
        }
    }

    private fun signIn() {
        findNavController().navigate(R.id.action_createAccountFragment_to_signInFragment)
    }

    private fun clearViews() {
        views {
            fullName.text.clear()
            emailAddress.text.clear()
            password.text.clear()
        }
    }

    private fun <T> views(block: FragmentCreateAccountBinding.() -> T): T? = binding?.block()
}