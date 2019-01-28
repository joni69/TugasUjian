package com.joni.tugasujian

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.joni.tugasujian.Utama.Video.VideoFragment
import kotlinx.android.synthetic.main.custombarsearch.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SearhActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searh)

        searhbtn.setOnClickListener {
            startActivity<MainActivity>("type" to textsearh.text.toString())
        }

    }

}
