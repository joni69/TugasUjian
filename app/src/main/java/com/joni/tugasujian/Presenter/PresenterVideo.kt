package com.joni.tugasujian.Presenter

import com.joni.kotlinapiyoutube.model.ResultGetData
import com.joni.tugasujian.Utama.Video.config.ConfigServiceO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterVideo(val view: PlacePresenter) {
    fun LoadData(part: String,maxhResult: String,q : String,key : String) {
        ConfigServiceO.getService().getData(part,maxhResult,q,key).enqueue(object : Callback<ResultGetData> {
            override fun onFailure(call: Call<ResultGetData>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResultGetData>, response: Response<ResultGetData>) {
                if (response.isSuccessful) {
                    val data = response.body()?.items
                    view.onResult(data as List<ResultGetData>)
                }
            }
        })
    }
}