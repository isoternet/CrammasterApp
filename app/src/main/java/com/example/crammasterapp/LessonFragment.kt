package com.example.crammasterapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.crammasterapp.databinding.LessonFragmentBinding


class LessonFragment(lessonNum: Int) : Fragment() {
    private lateinit var binding: LessonFragmentBinding
    private var lessonNum = lessonNum

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LessonFragmentBinding.inflate(layoutInflater)
        val view = binding.root

        binding.title.text = "Lesson $lessonNum"

        binding.slides.setOnClickListener {
            val uri: Uri = Uri.parse(resources.getStringArray(R.array.slide_urls)[lessonNum - 1])
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        binding.labs.setOnClickListener {
            val uri: Uri = Uri.parse(resources.getStringArray(R.array.lab_urls)[lessonNum - 1])
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        return view
    }
}