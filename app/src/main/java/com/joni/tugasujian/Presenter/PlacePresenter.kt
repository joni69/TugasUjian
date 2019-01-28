package com.joni.tugasujian.Presenter

import com.joni.kotlinapiyoutube.model.ResultGetData

interface PlacePresenter {
    fun onResult(data: List<ResultGetData>)
    fun onError()
}
