package com.example.crammasterapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.crammasterapp.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = WelcomeFragmentBinding.inflate(layoutInflater)
        val view = binding.root

        return view
    }
}