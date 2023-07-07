package com.example.intern.feedimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intern.R
import com.example.intern.newsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class feedActivity : AppCompatActivity() {
    lateinit var adapter: newsAdapter
    lateinit var rcycle: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        getnews()
        rcycle=findViewById(R.id.recycle)


    }

    private fun getnews() {
        val news = NewsService.newsInstance.getImage("in",1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news=response.body()
                if(news!=null){
                    Log.d("mohit",news.toString())
                    adapter=newsAdapter(this@feedActivity,news.articles)
                    rcycle.adapter=adapter
                    rcycle.layoutManager= LinearLayoutManager(this@feedActivity)
                }

            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("mohit","error in uploading image",t)
            }
        })
    }





    }
