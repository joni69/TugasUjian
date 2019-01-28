package com.joni.tugasujian.Utama.Video

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.joni.kotlinapiyoutube.model.ItemsItem
import com.joni.kotlinapiyoutube.model.ResultGetData
import com.joni.tugasujian.DBRoom.DataBase
import com.joni.tugasujian.DBRoom.DataBaseMeveo
import com.joni.tugasujian.MainActivity
import com.joni.tugasujian.R
import com.joni.tugasujian.Utama.Video.adapter.DetailAdapter
import com.joni.tugasujian.Utama.Video.adapter.VideoAdapter
import com.joni.tugasujian.Utama.Video.config.ConfigServiceO
import kotlinx.android.synthetic.main.activity_detail_video.*
import kotlinx.android.synthetic.main.custombarshow.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.activityManager
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailVideoActivity : YouTubeBaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_video)
        val judul = intent.getStringExtra("judul")
        val durasi = intent.getStringExtra("duration")
        val desc = intent.getStringExtra("desc")
        val id = intent.getStringExtra("id")


        juduldetail.text = judul
        durasidetail.text = durasi
        deskripsidetail.text = desc

        playbro.initialize("AIzaSyCkEYk1mg-TFin_BSL0ocPaYbjgoToPdPE", object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
                p1?.loadVideo(id)
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
            }
        })
        check(judul)
        showData()

    }

    private fun check(value: String?) {
        async(UI) {
            val check = bg {
                DataBase.getDatabase(this@DetailVideoActivity).userDao().loadAllByIds(value.toString())
            }
            action(check.await())
        }
    }

    private fun action(await: DataBaseMeveo) {

        if (await != null) {

            val id = DataBaseMeveo()
            id.id = await.id
            async(UI) {
                bg {
                    DataBase.getDatabase(this@DetailVideoActivity).userDao().delete(id)
                }
            }
            savedata()
        } else {
            savedata()
        }
    }


    private fun savedata() {
        val judul = intent.getStringExtra("judul")
        val durasi = intent.getStringExtra("duration")
        val desc = intent.getStringExtra("desc")
        val img = intent.getStringExtra("gambar")
        val id = intent.getStringExtra("id")

        val db = DataBaseMeveo()
        db.judul = judul
        db.description = desc
        db.publishedAt = durasi
        db.gambar = img
        db.key = id

        async(UI) {
            bg {
                DataBase.getDatabase(this@DetailVideoActivity).userDao().insertAll(db)
            }
        }
        ims.setOnClickListener {
            startActivity<MainActivity>()
        }
    }

    private fun showData() {
        val query = intent.getStringExtra("q")

        ConfigServiceO.getService().getData("snippet", "20", query, "AIzaSyDZkN67WMdSKl2-voCgoeXuf7IyXG5outw")
            .enqueue(object : Callback<ResultGetData> {
                override fun onFailure(call: Call<ResultGetData>, t: Throwable) {

                }

                override fun onResponse(call: Call<ResultGetData>, response: Response<ResultGetData>) {
                    if (response.isSuccessful) {
                        getData(response.body()?.items)
                    }
                }
            })
    }

    private fun getData(items: List<ItemsItem?>?) {
        recyleviewshow.adapter = DetailAdapter(items as List<ItemsItem>, object : DetailAdapter.onClicks {
            override fun click(Item: ItemsItem) {

                startActivity<DetailVideoActivity>(
                    "desc" to Item.snippet?.description.toString(),
                    "duration" to Item.snippet?.publishedAt.toString(),
                    "gambar" to Item.snippet?.thumbnails?.medium?.url.toString(),
                    "judul" to Item.snippet?.channelTitle.toString(),
                    "id" to Item.id?.videoId.toString(),
                    "q" to intent.getStringExtra("q")
                )
            }
        })
        recyleviewshow.layoutManager = LinearLayoutManager(this)
    }

}
