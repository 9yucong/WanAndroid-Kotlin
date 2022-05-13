package com.cong.wanandroid.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cong.wanandroid.net.bean.Article
import kotlinx.coroutines.flow.Flow

/**
 *
 * @Description:
 * @author: Cong.Gao
 * @date: 2022年05月12日
 */
object ArticleRepo {
    private const val PAGE_SIZE = 50

    fun getPagingData(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = { ArticlePagingSource() }).flow
    }
}