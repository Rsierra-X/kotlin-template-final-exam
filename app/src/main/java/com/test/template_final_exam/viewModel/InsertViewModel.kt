package com.test.template_final_exam.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.test.template_final_exam.MyApplication
import com.test.template_final_exam.database.entities.Mascota
import kotlinx.coroutines.launch

class InsertViewModel(val app: Application): AndroidViewModel(app) {
    fun save(mascota: Mascota) {
        viewModelScope.launch {
            (app as MyApplication).database.getMascotaDao().insertMascota(mascota)
        }
    }
}