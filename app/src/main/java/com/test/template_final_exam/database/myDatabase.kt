package com.test.template_final_exam.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.template_final_exam.database.dao.MascotaDao
import com.test.template_final_exam.database.entities.Mascota


const val DATABASE_VERSION = 1
const val DATABASE_NAME = "veterinaria"

@Database(
    entities = [Mascota::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getMascotaDao() : MascotaDao

    companion object {
        fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}