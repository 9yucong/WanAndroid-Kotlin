package com.cong.wanandroid.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * @Description:
 * @author: Cong.Gao
 * @date: 2022年05月12日
 */
class ApiService {
    companion object {
        private const val BASE_URL = "https://www.wanandroid.com/";
        private var apiService: WanAndroidApi? = null;

        fun getApi(): WanAndroidApi {
            if (apiService == null) {
                val httpLoggingInterceptor =
                    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
                val okHttpClient =
                    OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
                val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                apiService = retrofit.create(WanAndroidApi::class.java);
            }
            return apiService!!
        }
    }
}