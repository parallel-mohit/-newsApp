package com.example.intern.feedimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intern.R
import com.example.intern.databinding.ActivityFeedBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class feedActivity : AppCompatActivity() {
    lateinit var adapter: newsAdapter
    lateinit var rcycle: RecyclerView
    var i: Int = 1
    lateinit var binding: ActivityFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getnews(NewsService.newsInstance.getImage("in", 1))


        rcycle = findViewById(R.id.recycle)

        binding.swipe.setOnRefreshListener {
            i = loop(i)
            i++

            binding.swipe.isRefreshing = false
        }


    }

    private fun getnews(news: Call<News>) {


        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    Log.d("mohit", news.toString())
                    adapter = newsAdapter(this@feedActivity, news.articles)
                    rcycle.adapter = adapter
                    rcycle.layoutManager = LinearLayoutManager(this@feedActivity)
                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("mohit", "error in uploading image", t)
            }
        })
    }

    fun loop(i: Int): Int {

        if (i == 1) {
            getnews(NewsService.newsInstance.getImage("in", 2))
            return i

        }
        if (i == 2) {
            getnews(NewsService.newsInstance.getImage("us", 1))
            return i
        }
        if (i==3) {
            getnews(NewsService.newsInstance.getImage("in", 1))
            return i
        }else{
            getnews(NewsService.newsInstance.getImage("us", 2))
            return 0
        }


    }
}

