package com.example.practicalcodedemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicalcodedemo.R
import com.example.practicalcodedemo.data.model.Post
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        init()
    }

    private fun init() {
        var data = intent.getSerializableExtra("data") as Post

        Picasso.get()
            .load(data.avatar)
            .placeholder(R.drawable.ic_launcher_background)
            .into(image_view_avatar)

        text_view_name.text = data.name
        text_view_author.text = data.author
        text_view_description.text = data.description
        text_view_url.text = data.url
    }
}