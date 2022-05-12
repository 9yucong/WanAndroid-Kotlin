package com.cong.wanandroid.net.bean

/**
 *
 * @Description:
 * @author: Cong.Gao
 * @date: 2022年05月12日
 */
open class BaseResponse<T>(
    val errorCode: String,
    val errorMsg: String,
    val data: T
)
