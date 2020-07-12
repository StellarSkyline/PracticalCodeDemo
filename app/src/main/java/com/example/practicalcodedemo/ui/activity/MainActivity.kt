package com.example.practicalcodedemo.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.practicalcodedemo.R
import com.example.practicalcodedemo.data.vmodel.MainViewModel
import com.example.practicalcodedemo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //val viewModel:MainViewModel by viewModels()
    lateinit var viewModel:MainViewModel
    lateinit var mBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.mainViewModel = viewModel
        mBinding.lifecycleOwner = this

        init()
    }

    private fun init() {
        viewModel.checkLoading.observe(this, Observer {
            when(it) {
                true -> {
                    progressBar.visibility = View.GONE
                    val intent = Intent(this,DisplayActivity::class.java)
                    intent.putExtra("data",viewModel.postResponse.value)
                    startActivity(intent)
                }
                false -> {
                    progressBar.visibility = View.VISIBLE
                }
            }
        })
    }


}

