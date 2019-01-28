package com.joni.tugasujian.Utama.Home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.joni.kotlinapiyoutube.model.ItemsItem
import com.joni.tugasujian.R


import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.fragment_item2.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class HomeAdapter(
    private val mValues: List<ItemsItem>, val Click: onClickItems
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.itemView.onClick {
            Click.click(item)
        }

        holder.mIdView.text = item.snippet?.channelTitle
        holder.mContentView.text = item.snippet?.publishedAt
        holder.mdeskripsi.text = item.snippet?.description
        Picasso.get().load(item.snippet?.thumbnails?.medium?.url).into(holder.mContentView3)

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.judul1
        val mContentView: TextView = mView.content1
        val mContentView3: ImageView = mView.canel1
        val mdeskripsi: TextView = mView.deskripsi1

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }

    interface onClickItems {
        fun click(Item : ItemsItem)
    }
}
