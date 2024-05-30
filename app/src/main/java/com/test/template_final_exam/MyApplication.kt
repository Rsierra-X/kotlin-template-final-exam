package com.test.template_final_exam

import android.app.Application
import com.test.template_final_exam.database.MyDatabase

class MyApplication: Application() {
    lateinit var database: MyDatabase
    override fun onCreate() {
        super.onCreate()
        database = MyDatabase.buildDatabase(this)
    }
}