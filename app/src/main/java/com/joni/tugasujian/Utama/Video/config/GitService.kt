package com.joni.kotlinapiyoutube.config

import com.joni.kotlinapiyoutube.model.ResultGetData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitService {
    @GET("search?")
    fun getData(
        @Query("part") part: String,
        @Query("maxResults") maxResult :String,
        @Query("q") q : String,
        @Query("key") key : String
    ) : Call<ResultGetData>
}
