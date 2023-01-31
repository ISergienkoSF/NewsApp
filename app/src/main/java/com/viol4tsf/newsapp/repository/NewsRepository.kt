package com.viol4tsf.newsapp.repository

import com.viol4tsf.newsapp.api.RetrofitInstance
import com.viol4tsf.newsapp.db.ArticleDatabase
import com.viol4tsf.newsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews (searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    suspend fun delete(article: Article) = db.getArticleDao().deleteArticle(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()
}