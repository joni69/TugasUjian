package com.joni.tugasujian.Utama.History.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.joni.tugasujian.DBRoom.DataBaseMeveo
import com.joni.tugasujian.R

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_item2.view.*

import kotlinx.android.synthetic.main.fragment_item3.view.*
import org.jetbrains.anko.sdk25.coroutines.onLongClick

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class HistoryAdapter(
    private val mValues: List<DataBaseMeveo>, val mClick : onClIckitems
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item3, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.mView.setOnClickListener {
            mClick.Click(item,"1")
        }
        holder.mHapus.setOnClickListener {
            mClick.hapus(item)
        }
        holder.mView.onLongClick {
            mClick.Click(item,"2")
        }
        holder.mIdView.text = item.judul
        holder.mContentView.text = item.publishedAt
        holder.mdeskripsi.text = item.description
        Picasso.get().load(item.gambar).into(holder.mContentView3)

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.judul2
        val mContentView: TextView = mView.content2
        val mContentView3: ImageView = mView.canel2
        val mdeskripsi: TextView = mView.deskripsi2
        val mHapus : Button = mView.hapus

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }

    interface onClIckitems {
        fun Click(items : DataBaseMeveo,param: String)
        fun hapus(items: DataBaseMeveo)

    }
}
