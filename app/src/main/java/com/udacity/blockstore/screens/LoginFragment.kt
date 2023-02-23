package com.udacity.blockstore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.blockstore.R
import com.udacity.blockstore.databinding.FragmentLoginBinding

/**
 * Login Screen
 */
class LoginFragment : Fragment() {

    private val KEY_USERNAME = "key_username"
    private val KEY_PASSWORD = "key_password"

    private lateinit var binding: FragmentLoginBinding

    private var username = ""
    private var password = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Inflate view and get instance of binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        //Create Account Click Listener
        binding.createLoginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        //Login Click Listener
        binding.loginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        //Persist user entry for username and password (not a good idea for password in a production app usually)
        if(savedInstanceState != null) {
            username = savedInstanceState.getString(KEY_USERNAME).toString()
            password = savedInstanceState.getString(KEY_PASSWORD).toString()
        }
        binding.username = username
        binding.password = password

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_USERNAME, username)
        outState.putString(KEY_PASSWORD, password)
    }
}