package com.example.practicalcodedemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicalcodedemo.R
import com.example.practicalcodedemo.data.adapter.DisplayAdapter
import com.example.practicalcodedemo.data.model.Post
import com.example.practicalcodedemo.data.model.PostResponse
import com.example.practicalcodedemo.data.vmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {
    val viewModel:MainViewModel by viewModels()

    lateinit var adapter:DisplayAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)


        init()
    }

    private fun init() {
        var data = intent.getSerializableExtra("data") as ArrayList<Post>
        adapter = DisplayAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter.setData(data)
        recycler_view.adapter = adapter







    }
}