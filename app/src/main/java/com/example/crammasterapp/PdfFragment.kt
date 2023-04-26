package com.example.crammasterapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.crammasterapp.databinding.PdfFragmentBinding
import com.rajat.pdfviewer.PdfViewerActivity

class PdfFragment(title: String, fileName: String, projectProposal: Boolean) : Fragment() {
    private lateinit var binding: PdfFragmentBinding
    private val title = title
    private val fileName = fileName
    private val projectProposal = projectProposal

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PdfFragmentBinding.inflate(layoutInflater)
        val view = binding.root

        binding.title.text = title

        if (projectProposal) {
            binding.projectProposalTitle.visibility = View.VISIBLE
            binding.projectProposalDecoration.visibility = View.VISIBLE
            binding.projectProposalOpenButton.visibility = View.VISIBLE
        } else {
            binding.projectProposalTitle.visibility = View.GONE
            binding.projectProposalDecoration.visibility = View.GONE
            binding.projectProposalOpenButton.visibility = View.GONE
        }

        binding.openButton.setOnClickListener {
            startActivity(PdfViewerActivity.launchPdfFromPath(
                activity,
                fileName,
                title,
                "",
                enableDownload = true,
                fromAssets = true
            )
            )
        }

        binding.projectProposalOpenButton.setOnClickListener {
            startActivity(PdfViewerActivity.launchPdfFromPath(
                activity,
                "project-proposal.pdf",
                "Project Proposal",
                "",
                enableDownload = true,
                fromAssets = true
            )
            )
        }

        return view
    }
}