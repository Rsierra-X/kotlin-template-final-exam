package com.test.template_final_exam.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mascota")
data class  Mascota(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    var raza: String,
    var dueno: String
)
