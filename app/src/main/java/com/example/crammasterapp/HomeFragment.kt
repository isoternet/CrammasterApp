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
        announcements.add(Announcements("Test 1", "This is the first announcement"))
        announcements.add(Announcements("Test 2", "This is the second announcement"))
        announcements.add(Announcements("Test 3", "This is the third announcement"))
        announcements.add(Announcements("Test 4", "This is the fourth announcement"))
        announcements.add(Announcements("Test 5", "This is the fifth announcement"))
        announcements.add(Announcements("Test 6", "This is the sixth announcement"))

        return announcements
    }
}