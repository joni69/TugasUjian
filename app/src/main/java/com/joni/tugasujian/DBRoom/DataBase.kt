package com.joni.tugasujian.DBRoom

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(DataBaseMeveo::class), version = 1)

abstract class DataBase : RoomDatabase() {
    abstract fun userDao(): DataBaseMeveoDao

    companion object {
        fun getDatabase(context: Context): DataBase {
            val db = Room.databaseBuilder(
                context.applicationContext,
                DataBase::class.java, "database-name6"
            ).build()
            return db
        }
    }

}