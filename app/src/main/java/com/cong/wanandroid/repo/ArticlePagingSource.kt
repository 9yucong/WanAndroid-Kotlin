package com.cong.wanandroid.repo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cong.wanandroid.net.ApiService
import com.cong.wanandroid.net.bean.Article
import java.lang.Exception

/**
 *
 * @Description:
 * @author: Cong.Gao
 * @date: 2022年05月13日
 */
class ArticlePagingSource: PagingSource<Int, Article>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 0
            val pageSize = params.loadSize
            val articleList = ApiService.getApi().getHomeArticleList(page).data.datas
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (articleList.isNotEmpty()) page + 1 else null
            LoadResult.Page(articleList, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return null
    }
}