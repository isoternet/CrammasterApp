package com.example.crammasterapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crammasterapp.announcements.Announcements
import com.example.crammasterapp.announcements.AnnouncementsAdapter
import com.example.crammasterapp.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    private lateinit var binding: HomeFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var announcementsAdapter: AnnouncementsAdapter
    private lateinit var announcements: List<Announcements>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(layoutInflater)
        val view = binding.root

        announcements = getAnnouncements()

        recyclerView = view.findViewById(R.id.announcementRecycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        announcementsAdapter = AnnouncementsAdapter(announcements)
        recyclerView.adapter = announcementsAdapter

        return view
    }

    private fun getAnnouncements(): List<Announcements>{
        val announcements = mutableListOf<Announcements>()
        announcements.add(Announcements("Presentation Information", "Hello Class,\n" + "\n" +
                "Here is the link for \n" + "\n" + "1. the order to present your project.\n" +
                "2. the evaluation form to do peer evaluation.\n" +
                "https://kennesawedu-my.sharepoint.com/:f:/g/personal/lwang40_kennesaw_edu/EuMOkmYJOr5IpPGHwDoawFcBVUxuuzXTN0JHBTAUerEmUw?e=akgMGc\n" +
                "\n" + "Thanks,\n" + "\n" + "Lingyan Wang"))

        announcements.add(Announcements("Presentation Duration", "Hello Class,\n" + "\n" + "Good morning!\n" + "\n" +
                "In your presentation, you have 8-10 minutes. You can insert your demo video into your presentation, as a part, not only a demo video.\n"
                + "\n" + "Thanks,\n" + "\n" + "Lingyan Wang"))


        announcements.add(Announcements("Presentation Announcement", "Hello Class,\n" + "\n" +
                "Bellowing is our schedule. \n" + "\n" + "1. Next week, we will have the presentation of the project. Please check the group members and your topic.\n" +
                "\n" + "https://docs.google.com/document/d/10WiYcolf9f2bZM1kwG4Vx3EYOfv1aPzI/edit?usp=sharing&ouid=102627497799071551190&rtpof=true&sd=true\n" +
                "\n" + "    If your name is not there, please email me ASAP. During your presentation, please demo your project (including source code for functionality, API, database, and so on. And/or a video). \n" +
                "\n" + "2. Lab 13, as scheduled.\n" + "\n" + "3. The last exam, from Next week to May 5th, you can take it online.\n" +
                "\n" + "4. The slides and source code of the project, as scheduled. If you want to submit a video for a demo, it is ok. Please follow the instructions ( two documents) about the project on D2L.\n" +
                "\n" + "Thanks,\n" + "\n" + "Lingyan Wang"))

        announcements.add(Announcements("Lab 11", "Hello Class,\n" +
                "\n" + "About Lab 11, please finish 3 parts.\n" + "\n" + "Part 1: Getting data from the internet.\n" + "\n" +
                "Part 2: Loading and displaying images from the internet.\n" + "\n" +
                "Part 3: Android Kotlin Fundamentals: 08.3 Filtering and detail views with internet data\n" +
                "\n" + "Thanks,\n" + "\n" + "Lingyan Wang"))


        announcements.add(Announcements("Exam 3", "Hello Class,\n" +
                "\n" + "Based on most students' opinions, we will have Exam 3 in class tomorrow. Please go over the slides, and materials in codelab. After the exam, we will have a short lecture.\n" +
                "\n" + "Thanks,\n" + "\n" + "Lingyan Wang"))

        announcements.add(Announcements("Lab 9", "Hello Class,\n" +
                "\n" + "For Lab9, please do the Coding Challenges, including the dependences set-up, room, DAO and coroutines and test parts.\n" +
                "\n" + "Have a great weekend!\n" + "\n" + "Lingyan Wang"))

        return announcements
    }
}