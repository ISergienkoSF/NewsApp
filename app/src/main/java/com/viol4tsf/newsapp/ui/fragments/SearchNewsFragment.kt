package com.viol4tsf.newsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.viol4tsf.newsapp.R
import com.viol4tsf.newsapp.databinding.FragmentSavedNewsBinding
import com.viol4tsf.newsapp.databinding.FragmentSearchNewsBinding
import com.viol4tsf.newsapp.ui.MainActivity
import com.viol4tsf.newsapp.ui.viewmodels.NewsViewModel

class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {

    private var _binding: FragmentSearchNewsBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}