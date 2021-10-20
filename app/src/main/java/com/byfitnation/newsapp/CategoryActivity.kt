package com.byfitnation.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.byfitnation.newsapp.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvBusiness.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("category" , "business")
            startActivity(intent)
        }
        binding.tvBusiness.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("category" , "business")
            startActivity(intent)
        }
        binding.tvEntertainment.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("category" , "entertainment")
            startActivity(intent)
        }
        binding.tvGeneral.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("category" , "general")
            startActivity(intent)
        }
        binding.tvHealth.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("category" , "health")
            startActivity(intent)
        }
        binding.tvScience.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("category" , "science")
            startActivity(intent)
        }
        binding.tvSports.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("category" , "sports")
            startActivity(intent)
        }
        binding.tvTechnology.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("category" , "technology")
            startActivity(intent)
        }


    }
}