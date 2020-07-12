package com.example.practicalcodedemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.practicalcodedemo.R
import com.example.practicalcodedemo.data.vmodel.MainViewModel
import com.example.practicalcodedemo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel:MainViewModel by viewModels()
    lateinit var mBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                }
                false -> {
                    progressBar.visibility = View.VISIBLE
                }
            }
        })
    }


}

