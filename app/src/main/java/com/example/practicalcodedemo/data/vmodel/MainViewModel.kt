package com.example.practicalcodedemo.data.vmodel

import android.util.Log
import android.view.View
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
    var language:String = ""

    val postResponse by lazy {
        val x = MutableLiveData<PostResponse>()
        x.value = PostResponse()
        x
    }

    val checkLoading by lazy {MutableLiveData<Boolean>()}
    val checkFail by lazy {MutableLiveData<Boolean>()}


    fun getPosts(language:String) {
        viewModelScope.launch {
            val x = repo.getRepo(language, "daily","english")
            if(x.toString() != "[]") {
                withContext(Dispatchers.Main) {
                    postResponse.value = x
                    checkLoading.value = true
                    Log.d("STLog", postResponse.value.toString())
                }
            } else {
                withContext(Dispatchers.Main) {
                    checkFail.value = true

                }
            }
        }
    }

    fun onButtonClicked(view: View) {
        checkLoading.value = false
        getPosts(language)

    }
}