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

        bindingDrawerContent.home.setOnClickListener {
            (activity as NavigationHost).navigateTo(HomeFragment(), true)
        }

        bindingDrawerContent.welcome.setOnClickListener {
            (activity as NavigationHost).navigateTo(WelcomeFragment(), true)
        }

        bindingDrawerContent.syllabus.setOnClickListener {
            (activity as NavigationHost).navigateTo(PdfFragment("Syllabus", "syllabus.pdf", false), true)
        }

        bindingDrawerContent.labReportInstruction.setOnClickListener {
            (activity as NavigationHost).navigateTo(PdfFragment("Lab Report Instruction", "lab-report-instruction.pdf", false), true)
        }

        bindingDrawerContent.projectInstruction.setOnClickListener {
            (activity as NavigationHost).navigateTo(PdfFragment("Project Instruction", "project-instruction.pdf", true), true)
        }

        bindingDrawerContent.lesson1.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(1), true) }
        bindingDrawerContent.lesson2.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(2), true) }
        bindingDrawerContent.lesson3.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(3), true) }
        bindingDrawerContent.lesson4.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(4), true) }
        bindingDrawerContent.lesson5.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(5), true) }
        bindingDrawerContent.lesson6.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(6), true) }
        bindingDrawerContent.lesson7.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(7), true) }
        bindingDrawerContent.lesson8.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(8), true) }
        bindingDrawerContent.lesson9.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(9), true) }
        bindingDrawerContent.lesson10.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(10), true) }
        bindingDrawerContent.lesson11.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(11), true) }
        bindingDrawerContent.lesson12.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(12), true) }
        bindingDrawerContent.lesson13.setOnClickListener { (activity as NavigationHost).navigateTo(LessonFragment(13), true) }

        binding.logoutButton.setOnClickListener {
            (activity as NavigationHost).navigateTo(LoginFragment(false), false)
        }

        return binding.root
    }
}