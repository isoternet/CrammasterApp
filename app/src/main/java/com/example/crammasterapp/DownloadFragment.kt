package com.example.crammasterapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.crammasterapp.databinding.DownloadFragmentBinding
import com.pspdfkit.configuration.activity.PdfActivityConfiguration
import com.pspdfkit.ui.PdfActivity

class DownloadFragment(title: String, uri: String, projectProposal: Boolean) : Fragment() {
    private lateinit var binding: DownloadFragmentBinding
    private val title = title
    private val uri = uri
    private val projectProposal = projectProposal

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DownloadFragmentBinding.inflate(layoutInflater)
        val view = binding.root

        binding.title.text = title

        if (projectProposal) {
            binding.projectProposalTitle.visibility = View.VISIBLE
            binding.projectProposalDecoration.visibility = View.VISIBLE
            binding.projectProposalDownloadButton.visibility = View.VISIBLE
        } else {
            binding.projectProposalTitle.visibility = View.GONE
            binding.projectProposalDecoration.visibility = View.GONE
            binding.projectProposalDownloadButton.visibility = View.GONE
        }

        binding.downloadButton.setOnClickListener {
            val uri: Uri = Uri.parse(uri)
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        binding.projectProposalDownloadButton.setOnClickListener {
            val uri: Uri = Uri.parse(resources.getString(R.string.project_proposal))
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        return view
    }
}