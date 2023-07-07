package com.example.intern

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.intern.feedimage.img

class newsAdapter(val context: Context, val  articles : List<img>) : RecyclerView.Adapter<newsAdapter.imgViewHolder>(){
    class imgViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var newsImag = itemView.findViewById<ImageView>(R.id.rcimg)
//        var authortxt=itemView.findViewById<TextView>(R.id.authortxt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): imgViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return imgViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: imgViewHolder, position: Int) {
        val article =articles[position]
//        holder.authortxt.text=article.author
        Glide.with(context).load(article.urlToImage).into(holder.newsImag)
    }
}