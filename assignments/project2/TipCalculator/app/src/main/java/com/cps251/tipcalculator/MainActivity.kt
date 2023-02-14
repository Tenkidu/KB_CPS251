package com.cps251.tipcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cps251.tipcalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //button
        binding.tipBtn.setOnClickListener{
            var billAmount = binding.billAmount.text.toString().toFloat()

            var output10 = billAmount + 0.1*billAmount
            var output15 = billAmount + 0.15*billAmount
            var output20 = billAmount + 0.2*billAmount

            binding.output.text = "The tips are as follows:\n\n  10% = " +
                                    "$output10\n 15% = $output15\n 20% = $output20"
        }


    }
}