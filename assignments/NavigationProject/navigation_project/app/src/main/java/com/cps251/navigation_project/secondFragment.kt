package com.cps251.navigation_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.net.Uri
import com.cps251.navigation_project.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {


    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()
        arguments?.let {
            val args = SecondFragmentArgs.fromBundle(it)
            binding.argText.text = args.message
            binding.imageView.setImageResource(args.image)
        }
    }
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

}