package com.viol4tsf.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.viol4tsf.newsapp.R
import com.viol4tsf.newsapp.databinding.ActivityMainBinding
import com.viol4tsf.newsapp.db.ArticleDatabase
import com.viol4tsf.newsapp.repository.NewsRepository
import com.viol4tsf.newsapp.ui.viewmodels.NewsViewModel
import com.viol4tsf.newsapp.ui.viewmodels.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        binding.bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
    }
}
