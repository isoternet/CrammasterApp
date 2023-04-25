package com.example.crammasterapp

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.crammasterapp.database.User
import com.example.crammasterapp.database.UserDatabase
import com.example.crammasterapp.database.UserDatabaseDao
import com.example.crammasterapp.databinding.RegistrationFragmentBinding

class RegistrationFragment : Fragment() {
    private lateinit var binding: RegistrationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = RegistrationFragmentBinding.inflate(layoutInflater)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).userDatabaseDao

        binding.registerButton.setOnClickListener {
            var goodCredentials = true

            if(binding.usernameEditText.text.toString().isEmpty()) {
                binding.usernameTextInput.error = "Username cannot be blank."
                binding.usernameTextInput.boxBackgroundColor = resources.getColor(R.color.error_red)
                goodCredentials = false
            } else if(dataSource.get(binding.usernameEditText.text.toString()) != null) {
                binding.usernameTextInput.error = "This username already exists."
                binding.usernameTextInput.boxBackgroundColor = resources.getColor(R.color.error_red)
                goodCredentials = false
            } else {
                binding.usernameTextInput.error = null
                binding.usernameTextInput.boxBackgroundColor = resources.getColor(R.color.error_none)
            }

            if(!isPasswordValid(binding.passwordEditText.text)) {
                binding.passwordTextInput.error = "Password must contain at least 8 characters."
                binding.passwordTextInput.boxBackgroundColor = resources.getColor(R.color.error_red)
                goodCredentials = false
            } else {
                binding.passwordTextInput.error = null
                binding.passwordTextInput.boxBackgroundColor = resources.getColor(R.color.error_none)
            }

            if(binding.passwordEditText.text.toString() != binding.confirmPasswordEditText.text.toString()) {
                binding.confirmPasswordTextInput.error = "Passwords do not match."
                binding.confirmPasswordTextInput.boxBackgroundColor = resources.getColor(R.color.error_red)
                goodCredentials = false
            } else {
                binding.confirmPasswordTextInput.error = null
                binding.confirmPasswordTextInput.boxBackgroundColor = resources.getColor(R.color.error_none)
            }

            if (goodCredentials) {
                dataSource.insert(User(binding.usernameEditText.text.toString(), binding.passwordEditText.text.toString()))
                (activity as NavigationHost).navigateTo(HomeFragment(), false)
            }
        }

        binding.cancelButton.setOnClickListener {
            (activity as NavigationHost).navigateTo(LoginFragment(), false)
        }

        return view
    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }
}