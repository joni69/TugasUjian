package com.joni.tugasujian.DBRoom

import android.arch.persistence.room.*

@Dao
interface DataBaseMeveoDao {
    @Query("SELECT * FROM databasemeveo ORDER BY id DESC")
    fun getAll(): List<DataBaseMeveo>

    @Query("SELECT * FROM databasemeveo WHERE judul = :judul")
    fun loadAllByIds(judul: String): DataBaseMeveo

    @Insert
    fun insertAll(vararg databasemeveo: DataBaseMeveo)

    @Update

    fun update(vararg databasemeveo: DataBaseMeveo)
    @Delete
    fun delete(vararg databasemeveo: DataBaseMeveo)
}