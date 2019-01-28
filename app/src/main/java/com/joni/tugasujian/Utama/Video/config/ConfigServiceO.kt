package com.joni.tugasujian.Utama.Video.config

import com.joni.kotlinapiyoutube.config.GitService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConfigServiceO {
    fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .client(GetInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    fun GetInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return client
    }

    fun getService(): GitService {
        return getRetrofit().create(GitService::class.java)
    }
}