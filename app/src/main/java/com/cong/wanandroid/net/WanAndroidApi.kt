package com.cong.wanandroid.net

import com.cong.wanandroid.net.bean.ArticleList
import com.cong.wanandroid.net.bean.BaseResponse
import retrofit2.http.GET

/**
 *
 * @Description:
 * @author: Cong.Gao
 * @date: 2022年05月12日
 */
interface WanAndroidApi {
    @GET("article/list/0/json")
    suspend fun getHomeArticleList(): BaseResponse<ArticleList>
}