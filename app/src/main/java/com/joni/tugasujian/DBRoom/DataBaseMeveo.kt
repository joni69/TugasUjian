package com.joni.tugasujian.DBRoom

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class DataBaseMeveo {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @ColumnInfo(name = "judul")
    var judul: String? = null
    @ColumnInfo(name = "description")
    var description: String? = null
    @ColumnInfo(name = "key")
    var key: String? = null
    @ColumnInfo(name = "publishedAt")
    var publishedAt: String? = null
    @ColumnInfo(name = "gambar")
    var gambar: String? =null

}