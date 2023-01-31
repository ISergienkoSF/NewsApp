package com.viol4tsf.newsapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viol4tsf.newsapp.models.NewsResponse
import com.viol4tsf.newsapp.other.Resource
import com.viol4tsf.newsapp.repository.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(val newsRepository: NewsRepository) : ViewModel(){

        val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
        var breakingNewsPage = 1

        init {
            getBreakingNews("us")
        }

        fun getBreakingNews(countryCode: String) = viewModelScope.launch {
            breakingNews.postValue(Resource.Loading())
            val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
            breakingNews.postValue(handleBreakingNewsResponse(response))
        }

        private fun handleBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
            if(response.isSuccessful) {
                response.body()?.let { resultResponse ->
                    return Resource.Success(resultResponse)
                }
            }
            return Resource.Error(response.message())
        }
    }