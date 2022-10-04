package com.byfitnation.newsapp.repository

import com.byfitnation.newsapp.networking.NewsInstance
import com.byfitnation.newsapp.networking.NewsService

class NewsRepository(private val newsInstance: NewsInstance) {

    suspend fun getNews(country : String , category : String) = newsInstance.getHeadlines(country , category)

}