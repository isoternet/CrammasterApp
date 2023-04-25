package com.example.crammasterapp.announcements

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crammasterapp.R

class AnnouncementsAdapter(private val announcements: List<Announcements>):
    RecyclerView.Adapter<AnnouncementsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewTitle: TextView = itemView.findViewById(R.id.announcementTitle)
        val textViewBody: TextView = itemView.findViewById(R.id.announcementsBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.announcement_list_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = announcements.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val announcement = announcements[position]
        val title = announcement.title
        val body = announcement.body

        holder.textViewTitle.text = title
        holder.textViewBody.text = body
    }
}