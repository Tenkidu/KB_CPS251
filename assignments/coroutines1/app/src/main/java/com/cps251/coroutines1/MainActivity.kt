package com.cps251.coroutines1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cps251.coroutines1.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var viewModel: MainViewModel
    private val myCoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//RecycleAdapter
        layoutManager = LinearLayoutManager(this)
        binding.recylerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(viewModel.getNames())
        binding.recylerView.adapter = adapter
        binding.addNameBtn.setOnClickListener {
            displayName()
        }
    }
    private fun displayName() {
        myCoroutineScope.launch(Dispatchers.Main) {
            delay()
        }
    }
    //Delay
    @SuppressLint("NotifyDataSetChanged")
    private suspend fun delay() {
        val ranDelay = ((1..10).random() * 1000)
        val names = binding.enterName.text.toString()
        delay((ranDelay).toLong())
//Output
        if (title.isNotBlank()) {
            viewModel.addNames("The name is $names and the delay was $ranDelay milliseconds")
            adapter?.notifyDataSetChanged()
            binding.enterName.text.clear()
        }
    }
}