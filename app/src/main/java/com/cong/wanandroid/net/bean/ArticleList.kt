package com.cong.wanandroid.net.bean

/**
 *
 * @Description:
 * @author: Cong.Gao
 * @date: 2022年05月12日
 */
data class ArticleList(
    val curPage: Int,
    val datas: List<Article>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)
