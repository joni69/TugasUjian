package com.joni.tugasujian.Utama.Home


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.joni.tugasujian.R
import com.joni.tugasujian.Utama.Video.VideoFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment(private val menuselected: onMenuClick) : Fragment() {

    interface onMenuClick{
        fun klik(navigation_dashboard: Int)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card1.setOnClickListener {

            val fragtry = VideoFragment()
            val mBundle = Bundle()
            mBundle.putString("type", "lagu")
            fragtry.setArguments(mBundle)

            val mFragmentManager = fragmentManager
            val mFragmentTransaction = mFragmentManager!!
                .beginTransaction()
                .replace(R.id.container, fragtry, VideoFragment::class.java.simpleName)
            mFragmentTransaction.addToBackStack(null).commit()

//            menuselected.klik(R.id.navigation_dashboard)
        }
        card2.setOnClickListener {

//            val fragtry = VideoFragmentkedua()
            val fragtry = VideoFragment()
            val mBundle = Bundle()
            mBundle.putString("type", "seniman")
            fragtry.setArguments(mBundle)

            val mFragmentManager = fragmentManager
            val mFragmentTransaction = mFragmentManager!!
                .beginTransaction()
                .replace(R.id.container, fragtry, VideoFragment::class.java.simpleName)
            mFragmentTransaction.addToBackStack(null).commit()
        }
        card3.setOnClickListener {

//            val fragtry = VideoFragmentkedua()
            val fragtry = VideoFragment()
            val mBundle = Bundle()
            mBundle.putString("type", "berita")
            fragtry.setArguments(mBundle)

            val mFragmentManager = fragmentManager
            val mFragmentTransaction = mFragmentManager!!
                .beginTransaction()
                .replace(R.id.container, fragtry, VideoFragment::class.java.simpleName)
            mFragmentTransaction.addToBackStack(null).commit()
        }
        card4.setOnClickListener {

//            val fragtry = VideoFragmentkedua()
            val fragtry = VideoFragment()

            val mBundle = Bundle()
            mBundle.putString("type", "review")
            fragtry.setArguments(mBundle)

            val mFragmentManager = fragmentManager
            val mFragmentTransaction = mFragmentManager!!
                .beginTransaction()
                .replace(R.id.container, fragtry, VideoFragment::class.java.simpleName)
            mFragmentTransaction.addToBackStack(null).commit()
        }
        card5.setOnClickListener {

//            val fragtry = VideoFragmentkedua()
            val fragtry = VideoFragment()
            val mBundle = Bundle()
            mBundle.putString("type", "Game")
            fragtry.setArguments(mBundle)

            val mFragmentManager = fragmentManager
            val mFragmentTransaction = mFragmentManager!!
                .beginTransaction()
                .replace(R.id.container, fragtry, VideoFragment::class.java.simpleName)
            mFragmentTransaction.addToBackStack(null).commit()
        }
        card6.setOnClickListener {

//            val fragtry = VideoFragmentkedua()
            val fragtry = VideoFragment()
            val mBundle = Bundle()
            mBundle.putString("type", "Horor")
            fragtry.setArguments(mBundle)

            val mFragmentManager = fragmentManager
            val mFragmentTransaction = mFragmentManager!!
                .beginTransaction()
                .replace(R.id.container, fragtry, VideoFragment::class.java.simpleName)
            mFragmentTransaction.addToBackStack(null).commit()
        }
        card7.setOnClickListener {

            //            val fragtry = VideoFragmentkedua()
            val fragtry = VideoFragment()
            val mBundle = Bundle()
            mBundle.putString("type", "vastival")
            fragtry.setArguments(mBundle)

            val mFragmentManager = fragmentManager
            val mFragmentTransaction = mFragmentManager!!
                .beginTransaction()
                .replace(R.id.container, fragtry, VideoFragment::class.java.simpleName)
            mFragmentTransaction.addToBackStack(null).commit()
        }
        card8.setOnClickListener {

            //            val fragtry = VideoFragmentkedua()
            val fragtry = VideoFragment()
            val mBundle = Bundle()
            mBundle.putString("type", "prank")
            fragtry.setArguments(mBundle)

            val mFragmentManager = fragmentManager
            val mFragmentTransaction = mFragmentManager!!
                .beginTransaction()
                .replace(R.id.container, fragtry, VideoFragment::class.java.simpleName)
            mFragmentTransaction.addToBackStack(null).commit()
        }
    }
}
