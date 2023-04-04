package com.example.card_assignment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.util.Log
import com.example.card_assignment.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?: return

        val title = extras.getInt("title")
        val detail = extras.getInt("detail")
        val image = extras.getInt("image")
        binding.secondTitle.text = Data.titles[title]
        binding.secondDescription.text = Data.details[detail]
        binding.secondImage.setImageResource(Data.images[image])
//        val qString = extras.getString("qString")
//        val tag: String? = extras.getString("myname")

    }
}
