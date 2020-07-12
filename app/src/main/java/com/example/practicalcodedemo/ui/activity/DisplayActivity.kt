package com.example.practicalcodedemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.practicalcodedemo.R
import com.example.practicalcodedemo.data.model.Post
import com.example.practicalcodedemo.data.model.PostResponse
import com.example.practicalcodedemo.data.vmodel.MainViewModel

class DisplayActivity : AppCompatActivity() {
    lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        init()
    }

    private fun init() {

        var data = intent.getSerializableExtra("data") as ArrayList<Post>

        Log.d("STLog", "From DisplayActivity ${data}")
    }
}