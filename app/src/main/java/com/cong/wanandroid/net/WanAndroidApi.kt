package com.cong.wanandroid.net

import com.cong.wanandroid.net.bean.ArticleList
import com.cong.wanandroid.net.bean.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * @Description:
 * @author: Cong.Gao
 * @date: 2022年05月12日
 */
interface WanAndroidApi {
    @GET("article/list/{page}/json")
    suspend fun getHomeArticleList(@Path("page") page:Int): BaseResponse<ArticleList>
}