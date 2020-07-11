package com.example.practicalcodedemo.data.repo

import com.example.practicalcodedemo.data.network.ApiClient

class MainRepo {

    suspend fun getRepo(language:String,since:String, spoken_language_code:String ) = ApiClient.invoke().getRepo(language = language, since = since, spoken_language_code = spoken_language_code)
}