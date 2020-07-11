package com.example.practicalcodedemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.practicalcodedemo.R
import com.example.practicalcodedemo.data.vmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        viewModel.getPosts()
    }
}

