package com.joni.tugasujian.Utama.Video


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joni.kotlinapiyoutube.model.ItemsItem
import com.joni.kotlinapiyoutube.model.ResultGetData

import com.joni.tugasujian.R
import com.joni.tugasujian.Presenter.PlacePresenter
import com.joni.tugasujian.Presenter.PresenterVideo
import com.joni.tugasujian.Utama.Video.adapter.VideoAdapter
import kotlinx.android.synthetic.main.fragment_video.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class VideoFragment : Fragment(), PlacePresenter {

    //    var type: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val key = "AIzaSyDZkN67WMdSKl2-voCgoeXuf7IyXG5outw"
        val persenter = PresenterVideo(this)
        val type = arguments?.getString("type").toString()
        val src = activity?.intent?.getStringExtra("type")

        if (src != null) {
            persenter.LoadData("snippet", "50", src, key)
        } else {
            when (type) {
                "review" -> {
                    persenter.LoadData("snippet", "50", "review", key)
                }
                "berita" -> {
                    persenter.LoadData("snippet", "50", "breakingnew", key)
                }
                "Game" -> {
                    persenter.LoadData("snippet", "50", "Gamer", key)
                }
                "Horor" -> {
                    persenter.LoadData("snippet", "50", "horor", key)
                }
                "seniman" -> {
                    persenter.LoadData("snippet", "50", "seniman", key)
                }
                "lagu" -> {
                    persenter.LoadData("snippet", "50", "coverlagu", key)
                }
                "prank" -> {
                    persenter.LoadData("snippet", "50", "prank", key)
                }
                "vastival" -> {
                    persenter.LoadData("snippet", "50", "vestival", key)
                }
                "null" -> {
                    persenter.LoadData("snippet", "50", "", key)
                }
            }
        }
    }

    override fun onResult(data: List<ResultGetData>) {
        ShowData(data)
    }

    override fun onError() {
        toast("eroooor")
    }

    private fun ShowData(list: List<ResultGetData>) {

        recyclevideo.adapter = VideoAdapter(list as List<ItemsItem>, object : VideoAdapter.onClickItem {
            override fun click(Item: ItemsItem) {
                if (activity?.intent?.getStringExtra("type") != null) {
                    startActivity<DetailVideoActivity>(
                        "desc" to Item.snippet?.description.toString(),
                        "duration" to Item.snippet?.publishedAt.toString(),
                        "gambar" to Item.snippet?.thumbnails?.medium?.url.toString(),
                        "judul" to Item.snippet?.channelTitle.toString(),
                        "id" to Item.id?.videoId.toString(),
                        "q" to activity?.intent?.getStringExtra("type").toString()
                    )
                } else {
                    startActivity<DetailVideoActivity>(
                        "desc" to Item.snippet?.description.toString(),
                        "duration" to Item.snippet?.publishedAt.toString(),
                        "gambar" to Item.snippet?.thumbnails?.medium?.url.toString(),
                        "judul" to Item.snippet?.channelTitle.toString(),
                        "id" to Item.id?.videoId.toString(),
                        "q" to arguments?.getString("type").toString()
                    )
                }
            }
        })
        recyclevideo.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
    }
}
