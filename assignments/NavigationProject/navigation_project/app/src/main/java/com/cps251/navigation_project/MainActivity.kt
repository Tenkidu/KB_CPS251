package com.cps251.navigation_project

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cps251.navigation_project.ui.main.MainFragment

class MainActivity : AppCompatActivity(),SecondFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onFragmentInteraction(uri: Uri) {
    }
}