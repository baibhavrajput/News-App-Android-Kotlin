package com.byfitnation.newsapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.byfitnation.newsapp.R
import com.byfitnation.newsapp.models.Articles
import com.byfitnation.newsapp.models.News

class NewsAdapter(private val listener : NewsItemClicked) : RecyclerView.Adapter<NewsViewHolder>(){

    var articlesList : MutableList<Articles> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = NewsViewHolder(view)

        view.setOnClickListener {
            listener.onItemClicked(articlesList[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int){
        val currentItem = articlesList[position]
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.urlToImage).into(holder.image)
    }

    fun setNewsListItems(movieList: List<Articles>){
        articlesList.clear()
        articlesList.addAll(0, movieList)
        notifyItemChanged(0)
    }


}

interface NewsItemClicked{
    fun onItemClicked(item : Articles)
}

class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val titleView = itemView.findViewById<TextView>(R.id.titleView)
    val author = itemView.findViewById<TextView>(R.id.author)
    val image = itemView.findViewById<ImageView>(R.id.image)
}

