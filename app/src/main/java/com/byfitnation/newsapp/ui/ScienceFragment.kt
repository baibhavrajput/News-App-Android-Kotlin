package com.byfitnation.newsapp.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.byfitnation.newsapp.R
import com.byfitnation.newsapp.models.Articles
import com.byfitnation.newsapp.networking.NewsService
import com.byfitnation.newsapp.repository.NewsRepository
import com.byfitnation.newsapp.utils.NewsAdapter
import com.byfitnation.newsapp.utils.NewsItemClicked
import com.byfitnation.newsapp.viewModel.NewsViewModelFactory
import com.byfitnation.newsapp.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_science.*

class ScienceFragment : Fragment() , NewsItemClicked {

    lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_science, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleView.layoutManager = LinearLayoutManager(activity)
        adapter = NewsAdapter(this)
        recycleView.adapter = adapter
        val newsInstance = NewsService.getInstance()
        val newsRepository = NewsRepository(newsInstance)

        val viewModel = ViewModelProvider(this , NewsViewModelFactory(newsRepository)).get(NewsViewModel::class.java)
        viewModel.news.observe(viewLifecycleOwner , Observer {
            adapter.setNewsListItems(it)
        })

        viewModel.getNews("in" , "science")
    }

    override fun onItemClicked(item : Articles){
//        val url = "https://google.com/"
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(requireContext(), Uri.parse(item.url))
    }
}