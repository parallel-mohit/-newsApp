package com.example.intern.feedimage

import android.telecom.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL= "https://newsapi.org/"
const val API_KEY = "71e9dc356ab74ef48fd3f357b0f1c04f"

interface NewsInterface {

    @GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getImage(@Query("country") country: String, @Query("page") page: Int):retrofit2.Call<News>
}


object NewsService{
    val newsInstance :NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}

