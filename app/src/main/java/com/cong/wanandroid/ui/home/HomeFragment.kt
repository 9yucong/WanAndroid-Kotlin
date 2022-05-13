package com.cong.wanandroid.ui.home

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cong.wanandroid.R
import com.cong.wanandroid.databinding.FragmentHomeBinding
import com.cong.wanandroid.view.SpaceItemDecoration

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel.homeArticleList.observe(viewLifecycleOwner) {
            articleAdapter.setData(it.datas)
        }
        initView()
        return root
    }

    private fun initView() {
        articleAdapter = ArticleAdapter()
        val rvArticleList = binding.rvArticleList
        rvArticleList.adapter = articleAdapter
        rvArticleList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val spaceItemDecoration = SpaceItemDecoration(16)
        rvArticleList.addItemDecoration(spaceItemDecoration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}