package com.byfitnation.newsapp

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "6b08e0df42984034bb2b2d74704ccd64"
interface NewsInterFace {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("category") category:String, @Query("country") country : String, @Query("page") page:Int) : Call<News>
}

object NewsService {
    val newsInstance : NewsInterFace
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance = retrofit.create(NewsInterFace::class.java)


    }
}