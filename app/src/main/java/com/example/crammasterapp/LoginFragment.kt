package com.example.crammasterapp

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.crammasterapp.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LoginFragmentBinding.inflate(layoutInflater)
        val view = binding.root

        //error if password is less than 8 characters
        binding.nextButton.setOnClickListener {
            if (!isPasswordValid(binding.passwordEditText.text!!)) {
                binding.passwordTextInput.error = "Password must contain at least 8 characters."
            } else {
                binding.passwordTextInput.error = null
                (activity as NavigationHost).navigateTo(HomeFragment(), false)
            }
        }

        binding.passwordEditText.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(binding.passwordEditText.text!!)) {
                // Clear the error.
                binding.passwordEditText.error = null
            }
            false
        }

        return view
    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }
}