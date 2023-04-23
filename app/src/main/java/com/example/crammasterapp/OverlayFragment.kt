package com.example.crammasterapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.crammasterapp.databinding.OverlayDrawerContentBinding
import com.example.crammasterapp.databinding.OverlayFragmentBinding

class OverlayFragment : Fragment() {
    private lateinit var binding: OverlayFragmentBinding
    private lateinit var bindingDrawerContent: OverlayDrawerContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = OverlayFragmentBinding.inflate(layoutInflater)
        bindingDrawerContent = OverlayDrawerContentBinding.bind(binding.root)

        (activity as AppCompatActivity).setSupportActionBar(binding.appBar)
        binding.appBar.setNavigationOnClickListener(NavigationIconClickListener(requireActivity(), binding.drawer))

        bindingDrawerContent.startHere.setOnClickListener{ bindingDrawerContent.startHereExpandable.toggle() }
        bindingDrawerContent.learningModules.setOnClickListener{ bindingDrawerContent.learningModulesExpandable.toggle() }

        return binding.root
    }
}