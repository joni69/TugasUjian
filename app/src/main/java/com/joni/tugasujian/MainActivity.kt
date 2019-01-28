package com.joni.tugasujian

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.joni.tugasujian.Utama.History.HistoryFragment
import com.joni.tugasujian.Utama.Home.HomeFragment
import com.joni.tugasujian.Utama.Video.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custombar.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                setFragmen(HomeFragment(object :HomeFragment.onMenuClick{
                    override fun klik(navigation_dashboard: Int) {
                        navigation.selectedItemId = R.id.navigation_dashboard
                    }

                }))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                setFragmen(VideoFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                setFragmen(HistoryFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val intem = intent.getStringExtra("type")
        if (intem == null) {
            setFragmen(HomeFragment(object :HomeFragment.onMenuClick{
                override fun klik(navigation_dashboard: Int) {
                    navigation.selectedItemId = R.id.navigation_dashboard
                }
            }))
        }else{
            setFragmen(VideoFragment())
        }

        searh.setOnClickListener {
            startActivity<SearhActivity>()
        }
        im.setOnClickListener {
            startActivity<MainActivity>()
        }
    }

    fun setFragmen(fragment: Fragment){

        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }


}
