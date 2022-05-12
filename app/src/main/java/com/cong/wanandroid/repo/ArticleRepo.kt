package com.cong.wanandroid.repo

import com.cong.wanandroid.net.ApiService
import com.cong.wanandroid.net.bean.ArticleList
import com.cong.wanandroid.net.bean.BaseResponse

/**
 *
 * @Description:
 * @author: Cong.Gao
 * @date: 2022年05月12日
 */
class ArticleRepo {
    suspend fun getHomeArticle(): BaseResponse<ArticleList> {
        return ApiService.getApi().getHomeArticleList()
    }
}