package com.example.practicalcodedemo.data.vmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicalcodedemo.data.model.PostResponse
import com.example.practicalcodedemo.data.repo.MainRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel:ViewModel() {

    //instance my repo
    val repo = MainRepo()

    val postResponse by lazy {
        val x = MutableLiveData<PostResponse>()
        x.value = PostResponse()
        x
    }

    fun getPosts() {
        viewModelScope.launch {
            val x = repo.getRepo("kotlin", "daily","english")
            withContext(Dispatchers.Main) {
                postResponse.value = x
                Log.d("STLog", postResponse.value.toString())
            }
        }
    }
}