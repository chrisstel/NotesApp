package com.example.notes.ui.get_started

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentGetStartedBinding

class GetStartedFragment : Fragment() {
    private var binding: FragmentGetStartedBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentGetStartedBinding.inflate(layoutInflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        views {
            getStartedButton.setOnClickListener {
                findNavController().navigate(R.id.action_getStartedFragment_to_createAccountFragment)
            }

            alreadyHaveAccountText.setOnClickListener {
                findNavController().navigate(R.id.action_getStartedFragment_to_signInFragment)
            }
        }
    }

    private fun <T> views(block: FragmentGetStartedBinding.() -> T): T? = binding?.block()
}