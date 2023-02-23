package com.udacity.blockstore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.blockstore.R
import com.udacity.blockstore.databinding.FragmentWelcomeBinding

/**
 * Welcome Screen
 */
class  WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Inflate view and get instance of binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        //Create Instructions Click Listener
        binding.instructionsButton.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
        }

        return binding.root
    }
}