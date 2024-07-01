package com.example.notes.ui.getstarted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentGetStartedBinding

class GetStartedFragment : Fragment() {
    private var binding: FragmentGetStartedBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentGetStartedBinding.inflate(layoutInflater, container, false).also { binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.getStartedButton?.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_getStartedFragment_to_mainFragment)
        }
    }
}