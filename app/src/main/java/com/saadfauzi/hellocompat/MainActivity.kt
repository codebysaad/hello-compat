package com.saadfauzi.hellocompat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.saadfauzi.hellocompat.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val KEY_COLOR = "color"
    private val arrayColor = arrayListOf("red",
        "pink",
        "purple",
        "deep_purple",
        "indigo",
        "blue",
        "light_blue",
        "cyan",
        "teal",
        "green",
        "light_green",
        "lime",
        "yellow",
        "amber",
        "orange",
        "deep_orange",
        "brown",
        "grey",
        "blue_grey",
        "black")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            binding.tvHelloWorld.setTextColor(savedInstanceState.getInt(KEY_COLOR))
        }

        binding.btnChangeColor.setOnClickListener { changeColor() }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_COLOR, binding.tvHelloWorld.currentTextColor)
    }

    fun changeColor(){
        val random = Random
        val colorName = arrayColor[random.nextInt(20)]
        val colorResName = resources.getIdentifier(colorName, KEY_COLOR, applicationContext.packageName)
        val colorRes = ContextCompat.getColor(this, colorResName)

        binding.tvHelloWorld.setTextColor(colorRes)
    }
}