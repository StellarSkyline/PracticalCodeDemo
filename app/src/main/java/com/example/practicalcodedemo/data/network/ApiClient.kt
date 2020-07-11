package com.example.practicalcodedemo.data.network

import com.example.practicalcodedemo.data.app.Config
import com.example.practicalcodedemo.data.model.PostResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("repositories")
    suspend fun getRepo(@Query("language")language:String,
                        @Query("since")since:String,
                        @Query("spoken_language_code")spoken_language_code:String):PostResponse

    companion object{
        operator fun invoke():ApiClient {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(Config.BASE_URL)
                .build()
                .create(ApiClient::class.java)
        }
    }
}