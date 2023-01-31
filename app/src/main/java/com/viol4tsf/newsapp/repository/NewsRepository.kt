package com.viol4tsf.newsapp.repository

import com.viol4tsf.newsapp.api.RetrofitInstance
import com.viol4tsf.newsapp.db.ArticleDatabase

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}