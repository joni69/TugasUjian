package com.joni.tugasujian.Utama.History


import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.joni.tugasujian.DBRoom.DataBase
import com.joni.tugasujian.DBRoom.DataBaseMeveo

import com.joni.tugasujian.R
import com.joni.tugasujian.Utama.History.adapter.HistoryAdapter
import com.joni.tugasujian.Utama.Video.DetailVideoActivity
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.startActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()

    }
    fun getData() {
        async(UI) {
            val data = bg {
                activity?.let { DataBase.getDatabase(it).userDao().getAll() }
            }
            data.await()?.let { showData(it) }
        }
    }

    private fun showData(await: List<DataBaseMeveo>) {
        recyclehistori.adapter = HistoryAdapter(await,object : HistoryAdapter.onClIckitems{
            override fun hapus(items: DataBaseMeveo) {
                val alert = activity?.let { AlertDialog.Builder(it) }
                alert?.setTitle("Perhatian")
                alert?.setCancelable(false)
                alert?.setMessage("yakin menghapusnya  " + items.judul)
                alert?.setNegativeButton("No"){dialog, which ->

                }
                alert?.setPositiveButton(
                    "yes"
                ) { dialog, which ->
                    var id = DataBaseMeveo()
                    id.id = items.id
                    async(UI) {

                        bg {
                            activity?.let { DataBase.getDatabase(it).userDao().delete(id) }
                        }
                        getData()
                        Toast.makeText(activity, "berhasil", Toast.LENGTH_SHORT).show()

                    }
                }?.show()
            }

            override fun Click(items: DataBaseMeveo,param : String) {
                if (param == "1"){
                    startActivity<DetailVideoActivity>(
                        "desc" to items.description.toString(),
                        "duration" to items.publishedAt.toString(),
                        "gambar" to items.gambar.toString(),
                        "judul" to items.judul.toString(),
                        "id" to items.key.toString(),
                        "q" to arguments?.getString("type").toString()
                    )
                }else{
                    val alert = activity?.let { AlertDialog.Builder(it) }
                    alert?.setTitle("Perhatian")
                    alert?.setCancelable(false)
                    alert?.setMessage("yakin menghapusnya  " + items.judul)
                    alert?.setNegativeButton("No"){dialog, which ->

                    }
                    alert?.setPositiveButton(
                        "yes"
                    ) { dialog, which ->
                        val id = DataBaseMeveo()
                        id.id = items.id
                        async(UI) {

                            bg {
                                activity?.let { DataBase.getDatabase(it).userDao().delete(id) }
                            }
                            getData()
                            Toast.makeText(activity, "berhasil", Toast.LENGTH_SHORT).show()
                        }
                    }?.show()
                }
            }
        })
        recyclehistori.layoutManager = LinearLayoutManager(context)
    }

}
