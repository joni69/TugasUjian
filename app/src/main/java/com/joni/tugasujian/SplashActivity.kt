package com.joni.tugasujian

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        CountDown()

    }

    private fun CountDown() {
        object : CountDownTimer(6000, 1000) {
            override fun onFinish() {
                websiteku.text = "0"
            }

            override fun onTick(millisUntilFinished: Long) {
                websiteku.text = (millisUntilFinished / 1000).toString()
                if (websiteku.text == "1") {
                    Handler().postDelayed(Runnable {
                        startActivity<MainActivity>()
                        finish()
                    }, 1000)
                } else {

                }
            }
        }.start()
    }
}

