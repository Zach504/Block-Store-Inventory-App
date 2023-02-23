package com.udacity.blockstore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.blockstore.BlocksViewModel
import com.udacity.blockstore.R
import com.udacity.blockstore.databinding.FragmentLoginBinding

/**
 * Login Screen
 */
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val blocksViewModel: BlocksViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Inflate view and get instance of binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.blocksViewModel = blocksViewModel
        //Create Account Click Listener
        binding.createLoginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        //Login Click Listener
        binding.loginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        return binding.root
    }
}