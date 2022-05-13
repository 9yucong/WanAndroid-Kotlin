package com.cong.wanandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cong.wanandroid.net.bean.Article
import com.cong.wanandroid.repo.ArticleRepo
import kotlinx.coroutines.flow.Flow

class HomeViewModel : ViewModel() {
    fun getPagingArticle():Flow<PagingData<Article>> {
        return ArticleRepo.getPagingData().cachedIn(viewModelScope)
    }
}