package com.cong.wanandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.cong.wanandroid.repo.ArticleRepo

class HomeViewModel : ViewModel() {
    private val articleRepo = ArticleRepo()
    val homeArticleList = liveData { emit(articleRepo.getHomeArticle()) }
}