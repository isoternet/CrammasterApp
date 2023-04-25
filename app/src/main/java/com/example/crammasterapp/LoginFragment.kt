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

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LoginFragmentBinding.inflate(layoutInflater)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).userDatabaseDao


        binding.loginButton.setOnClickListener {
            val user = dataSource.get(binding.usernameEditText.text.toString())

            //Replace false with user?.password.toString() != binding.passwordEditText.text.toString()
            if(false) {
                binding.passwordTextInput.error = "Incorrect username/password"
            } else {
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