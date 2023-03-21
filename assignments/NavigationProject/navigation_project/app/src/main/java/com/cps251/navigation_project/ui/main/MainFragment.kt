package com.cps251.navigation_project.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.cps251.navigation_project.R
import com.cps251.navigation_project.R.*
import com.cps251.navigation_project.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel=
            ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button1.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
            action.message="Image1"
            action.image = R.drawable.android_image_1
            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
            MainFragmentDirections.mainToSecond()
            action.message="Image2"
            action.image = R.drawable.android_image_2
            Navigation.findNavController(it).navigate(action)
            }
        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
            MainFragmentDirections.mainToSecond()
            action.message="Image3"
            action.image = R.drawable.android_image_3
            Navigation.findNavController(it).navigate(action)
        }
    }
}









