package com.joni.tugasujian.Utama.Video.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.joni.kotlinapiyoutube.model.ItemsItem
import com.joni.tugasujian.R
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.fragment_item.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class VideoAdapter(
    private val mValues: List<ItemsItem>, val Click: onClickItem
) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
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
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        val mContentView3: ImageView = mView.canel
        val mdeskripsi: TextView = mView.deskripsi

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }

    interface onClickItem {
        fun click(Item : ItemsItem)
    }

}
