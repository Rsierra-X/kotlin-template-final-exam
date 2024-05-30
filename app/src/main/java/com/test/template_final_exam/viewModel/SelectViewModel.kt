package com.test.template_final_exam.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.test.template_final_exam.MyApplication
import com.test.template_final_exam.adapter.MascotaAdapter
import com.test.template_final_exam.database.entities.Mascota
import kotlinx.coroutines.launch

class SelectViewModel (val app: Application): AndroidViewModel(app) {
    private val _mascotas: MutableLiveData<List<Mascota>> = MutableLiveData(emptyList())
    val mascotas: LiveData<List<Mascota>> = _mascotas

    fun loadMascotas() {
        viewModelScope.launch {
            val arrayData = (app as MyApplication).database.getMascotaDao().getAllMascota()
            _mascotas.postValue(arrayData)
        }
    }

    fun deleteMascota(mascota: Mascota, adapter: MascotaAdapter) {
        adapter.deleteItem(mascota)
        viewModelScope.launch {
            (app as MyApplication).database.getMascotaDao().deleteMascota(mascota)
        }
    }

    fun updateMascota(mascota: Mascota, adapter: MascotaAdapter) {
        adapter.updateItem(mascota)
        viewModelScope.launch {
            (app as MyApplication).database.getMascotaDao().updateMascota(mascota)
        }
    }
}