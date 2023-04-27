package com.example.crammasterapp

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.crammasterapp.database.UserDatabase
import com.example.crammasterapp.databinding.LoginFragmentBinding

class LoginFragment(accountConfirmation: Boolean) : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    private val accountConfirmation = accountConfirmation

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LoginFragmentBinding.inflate(layoutInflater)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).userDatabaseDao

        if(accountConfirmation) {
            binding.confirmationText.visibility = View.VISIBLE
        } else {
            binding.confirmationText.visibility = View.INVISIBLE
        }

        binding.loginButton.setOnClickListener {
            val user = dataSource.get(binding.usernameEditText.text.toString())

            if(user?.password.toString() != binding.passwordEditText.text.toString()) {
                binding.passwordTextInput.error = "Incorrect username/password"
                binding.passwordTextInput.boxBackgroundColor = resources.getColor(R.color.error_red)
            } else {
                binding.passwordTextInput.error = null
                binding.passwordTextInput.boxBackgroundColor = resources.getColor(R.color.error_none)
                (activity as NavigationHost).navigateTo(HomeFragment(), false)
            }
        }

        binding.registerButton.setOnClickListener {
            (activity as NavigationHost).navigateTo(RegistrationFragment(), false)
        }

        binding.printButton.setOnClickListener {
            for (user in dataSource.getAllUsers()) {
                println(user.username + " " + user.password)
            }
        }

        binding.clearButton.setOnClickListener {
            dataSource.clear()
        }

        binding.loginText.setOnClickListener {
            if(binding.debugLayout.isVisible) {
                binding.debugLayout.visibility = View.GONE
            } else {
                binding.debugLayout.visibility = View.VISIBLE
            }
        }

        return view
    }
}